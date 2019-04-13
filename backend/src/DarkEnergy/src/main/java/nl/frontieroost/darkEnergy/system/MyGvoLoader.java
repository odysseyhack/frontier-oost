package nl.frontieroost.darkEnergy.system;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import nl.frontieroost.darkEnergy.contract.MyGvo;
import nl.frontieroost.darkEnergy.services.MyGvoService;

/**
 * Tries to make connection to smart contract(s) BaseContract and AssetMonitoringContract
 * Creates temp. wallet.
 * <p>
 * NOTE: If you run this, alter the File path for the wallet directory
 *
 * @author Wely
 */
@Component
public class MyGvoLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(MyGvoLoader.class);

    private static final String ETH_MY_GVO_CONTRACT_ADDRESS = "0x92c85ce35B4f59Da8d85AFfe3F3B55E83A78d37C";

    private Web3j web3j;

    private MyGvo myGvoContract;

    @Autowired
    private MyGvoService myGvoService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        final File file;

        try {
            log.info("started loading MyGvoContract");

            //ALTER THIS PATH
            file = new File("/Users/roelvanwely/repos/frontier-oost/backend/src/DarkEnergy/src/main/java/nl/frontieroost/darkEnergy/wallets");

            final String walletSource = WalletUtils.generateLightNewWalletFile("supersafepassword", file);
            log.info("Created file: " + walletSource);

            web3j = Web3j.build(new HttpService());
            log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());

            Credentials credentials =
                WalletUtils.loadCredentials(
                    "supersafepassword", file.getAbsolutePath() + "/" + walletSource);
            log.info("Credentials loaded");

            DefaultGasProvider gasProvider = new DefaultGasProvider();
            log.info("Gasprovider created");

            myGvoContract = MyGvo.load(ETH_MY_GVO_CONTRACT_ADDRESS, web3j, credentials, gasProvider);
            myGvoService.setMyGvoContract(myGvoContract);
            log.info("MyGvoContract loaded");

            log.info("Loading MyGvo's from SC");
            int myGvoCounter = myGvoService.loadMGvoTokens();
            log.info("MyGvo's count: {}", myGvoCounter);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
