package nl.frontieroost.darkEnergy.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class MyGvo extends Contract {
    private static final String BINARY = "60806040523480156200001157600080fd5b506040518060400160405280600581526020017f4d7947766f0000000000000000000000000000000000000000000000000000008152506040518060400160405280600481526020017f4d47564f000000000000000000000000000000000000000000000000000000008152508181620000986301ffc9a760e01b6200013960201b60201c565b620000b06380ac58cd60e01b6200013960201b60201c565b620000c863780e9d6360e01b6200013960201b60201c565b8151620000dd90600990602085019062000270565b508051620000f390600a90602084019062000270565b506200010c635b5e139f60e01b6200013960201b60201c565b505050506200012133620001a660201b60201c565b600d80546001600160a01b0319163317905562000315565b7fffffffff0000000000000000000000000000000000000000000000000000000080821614156200016957600080fd5b7fffffffff00000000000000000000000000000000000000000000000000000000166000908152602081905260409020805460ff19166001179055565b620001c181600c620001f860201b6200171a1790919060201c565b6040516001600160a01b038216907f6ae172837ea30b801fbfcdd4108aa1d5bf8ff775444fd70256b44e6bf3dfc3f690600090a250565b6200020a82826200023a60201b60201c565b156200021557600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b60006001600160a01b0382166200025057600080fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620002b357805160ff1916838001178555620002e3565b82800160010185558215620002e3579182015b82811115620002e3578251825591602001919060010190620002c6565b50620002f1929150620002f5565b5090565b6200031291905b80821115620002f15760008155600101620002fc565b90565b611a9380620003256000396000f3fe608060405234801561001057600080fd5b50600436106101a95760003560e01c806342966c68116100f95780639865027511610097578063b88d4fde11610071578063b88d4fde14610781578063c87b56dd14610845578063cd31eb1a14610862578063e985e9c514610906576101a9565b80639865027514610725578063a22cb4651461072d578063aa271e1a1461075b576101a9565b80636352211e116100d35780636352211e146106b457806370a08231146106d157806395d89b41146106f7578063983b2d56146106ff576101a9565b806342966c68146105d45780634c467d30146105f15780634f6ccce714610697576101a9565b806323b872dd116101665780632f745c59116101405780632f745c591461049757806339f6a34f146104c357806340c10f191461057257806342842e0e1461059e576101a9565b806323b872dd1461038b57806326dd860a146103c1578063278e79041461047a576101a9565b806301ffc9a7146101ae57806306fdde03146101e9578063081812fc14610266578063095ea7b31461029f57806318160ddd146102cd5780631848873e146102e7575b600080fd5b6101d5600480360360208110156101c457600080fd5b50356001600160e01b031916610934565b604080519115158252519081900360200190f35b6101f1610953565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561022b578181015183820152602001610213565b50505050905090810190601f1680156102585780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6102836004803603602081101561027c57600080fd5b50356109ea565b604080516001600160a01b039092168252519081900360200190f35b6102cb600480360360408110156102b557600080fd5b506001600160a01b038135169060200135610a1a565b005b6102d5610ac7565b60408051918252519081900360200190f35b610283600480360360208110156102fd57600080fd5b810190602081018135600160201b81111561031757600080fd5b82018360208201111561032957600080fd5b803590602001918460018302840111600160201b8311171561034a57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610acd945050505050565b6102cb600480360360608110156103a157600080fd5b506001600160a01b03813581169160208101359091169060400135610b5b565b6102cb600480360360608110156103d757600080fd5b6001600160a01b0382351691602081013591810190606081016040820135600160201b81111561040657600080fd5b82018360208201111561041857600080fd5b803590602001918460018302840111600160201b8311171561043957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610b7e945050505050565b6102836004803603602081101561049057600080fd5b5035610b92565b6102d5600480360360408110156104ad57600080fd5b506001600160a01b038135169060200135610bad565b6102cb600480360360408110156104d957600080fd5b810190602081018135600160201b8111156104f357600080fd5b82018360208201111561050557600080fd5b803590602001918460018302840111600160201b8311171561052657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550505090356001600160a01b03169150610bfa9050565b6101d56004803603604081101561058857600080fd5b506001600160a01b038135169060200135610c99565b6102cb600480360360608110156105b457600080fd5b506001600160a01b03813581169160208101359091169060400135610cc0565b6102cb600480360360208110156105ea57600080fd5b5035610cdb565b6102cb6004803603604081101561060757600080fd5b810190602081018135600160201b81111561062157600080fd5b82018360208201111561063357600080fd5b803590602001918460018302840111600160201b8311171561065457600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505091359250610cfa915050565b6102d5600480360360208110156106ad57600080fd5b5035610d94565b610283600480360360208110156106ca57600080fd5b5035610dc8565b6102d5600480360360208110156106e757600080fd5b50356001600160a01b0316610df0565b6101f1610e26565b6102cb6004803603602081101561071557600080fd5b50356001600160a01b0316610e87565b6102cb610ea2565b6102cb6004803603604081101561074357600080fd5b506001600160a01b0381351690602001351515610ead565b6101d56004803603602081101561077157600080fd5b50356001600160a01b0316610f31565b6102cb6004803603608081101561079757600080fd5b6001600160a01b03823581169260208101359091169160408201359190810190608081016060820135600160201b8111156107d157600080fd5b8201836020820111156107e357600080fd5b803590602001918460018302840111600160201b8311171561080457600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610f44945050505050565b6101f16004803603602081101561085b57600080fd5b5035610f64565b6102d56004803603602081101561087857600080fd5b810190602081018135600160201b81111561089257600080fd5b8201836020820111156108a457600080fd5b803590602001918460018302840111600160201b831117156108c557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611017945050505050565b6101d56004803603604081101561091c57600080fd5b506001600160a01b03813581169160200135166110b3565b6001600160e01b03191660009081526020819052604090205460ff1690565b60098054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156109df5780601f106109b4576101008083540402835291602001916109df565b820191906000526020600020905b8154815290600101906020018083116109c257829003601f168201915b505050505090505b90565b60006109f5826110e1565b6109fe57600080fd5b506000908152600260205260409020546001600160a01b031690565b6000610a2582610dc8565b9050806001600160a01b0316836001600160a01b03161415610a4657600080fd5b336001600160a01b0382161480610a625750610a6281336110b3565b610a6b57600080fd5b60008281526002602052604080822080546001600160a01b0319166001600160a01b0387811691821790925591518593918516917f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92591a4505050565b60075490565b600080826040516020018082805190602001908083835b60208310610b035780518252601f199092019160209182019101610ae4565b51815160209384036101000a60001901801990921691161790526040805192909401828103601f1901835284528151918101919091206000908152600e90915291909120546001600160a01b03169695505050505050565b610b6533826110fe565b610b6e57600080fd5b610b79838383611155565b505050565b610b888383611174565b610b798282611195565b600e602052600090815260409020546001600160a01b031681565b6000610bb883610df0565b8210610bc357600080fd5b6001600160a01b0383166000908152600560205260409020805483908110610be757fe5b9060005260206000200154905092915050565b6000826040516020018082805190602001908083835b60208310610c2f5780518252601f199092019160209182019101610c10565b51815160209384036101000a60001901801990921691161790526040805192909401828103601f1901835284528151918101919091206000908152600e9091529190912080546001600160a01b0319166001600160a01b0396909616959095179094555050505050565b6000610ca433610f31565b610cad57600080fd5b610cb78383611174565b50600192915050565b610b7983838360405180602001604052806000815250610f44565b610ce533826110fe565b610cee57600080fd5b610cf7816111c6565b50565b6000826040516020018082805190602001908083835b60208310610d2f5780518252601f199092019160209182019101610d10565b51815160209384036101000a60001901801990921691161790526040805192909401828103601f1901835284528151918101919091206000818152600e90925292902054919450506001600160a01b03169150610d8e90508184611174565b50505050565b6000610d9e610ac7565b8210610da957600080fd5b60078281548110610db657fe5b90600052602060002001549050919050565b6000818152600160205260408120546001600160a01b031680610dea57600080fd5b92915050565b60006001600160a01b038216610e0557600080fd5b6001600160a01b0382166000908152600360205260409020610dea906111d8565b600a8054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156109df5780601f106109b4576101008083540402835291602001916109df565b610e9033610f31565b610e9957600080fd5b610cf7816111dc565b610eab33611224565b565b6001600160a01b038216331415610ec357600080fd5b3360008181526004602090815260408083206001600160a01b03871680855290835292819020805460ff1916861515908117909155815190815290519293927f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31929181900390910190a35050565b6000610dea600c8363ffffffff61126c16565b610f4f848484610b5b565b610f5b848484846112a1565b610d8e57600080fd5b6060610f6f826110e1565b610f7857600080fd5b6000828152600b602090815260409182902080548351601f60026000196101006001861615020190931692909204918201849004840281018401909452808452909183018282801561100b5780601f10610fe05761010080835404028352916020019161100b565b820191906000526020600020905b815481529060010190602001808311610fee57829003601f168201915b50505050509050919050565b600080826040516020018082805190602001908083835b6020831061104d5780518252601f19909201916020918201910161102e565b51815160209384036101000a60001901801990921691161790526040805192909401828103601f1901835284528151918101919091206000818152600e90925292902054919450506001600160a01b031691506110ab905081610df0565b949350505050565b6001600160a01b03918216600090815260046020908152604080832093909416825291909152205460ff1690565b6000908152600160205260409020546001600160a01b0316151590565b60008061110a83610dc8565b9050806001600160a01b0316846001600160a01b031614806111455750836001600160a01b031661113a846109ea565b6001600160a01b0316145b806110ab57506110ab81856110b3565b6111608383836113da565b61116a83826114ba565b610b7982826115af565b61117e82826115ed565b61118882826115af565b6111918161168e565b5050565b61119e826110e1565b6111a757600080fd5b6000828152600b602090815260409091208251610b799284019061196b565b610cf76111d282610dc8565b826116d2565b5490565b6111ed600c8263ffffffff61171a16565b6040516001600160a01b038216907f6ae172837ea30b801fbfcdd4108aa1d5bf8ff775444fd70256b44e6bf3dfc3f690600090a250565b611235600c8263ffffffff61175316565b6040516001600160a01b038216907fe94479a9f7e1952cc78f2d6baab678adc1b772d936c6583def489e524cb6669290600090a250565b60006001600160a01b03821661128157600080fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b60006112b5846001600160a01b0316611788565b6112c1575060016110ab565b604051600160e11b630a85bd0102815233600482018181526001600160a01b03888116602485015260448401879052608060648501908152865160848601528651600095928a169463150b7a029490938c938b938b939260a4019060208501908083838e5b8381101561133e578181015183820152602001611326565b50505050905090810190601f16801561136b5780820380516001836020036101000a031916815260200191505b5095505050505050602060405180830381600087803b15801561138d57600080fd5b505af11580156113a1573d6000803e3d6000fd5b505050506040513d60208110156113b757600080fd5b50516001600160e01b031916600160e11b630a85bd010214915050949350505050565b826001600160a01b03166113ed82610dc8565b6001600160a01b03161461140057600080fd5b6001600160a01b03821661141357600080fd5b61141c8161178e565b6001600160a01b038316600090815260036020526040902061143d906117c9565b6001600160a01b038216600090815260036020526040902061145e906117e0565b60008181526001602052604080822080546001600160a01b0319166001600160a01b0386811691821790925591518493918716917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef91a4505050565b6001600160a01b0382166000908152600560205260408120546114e490600163ffffffff6117e916565b60008381526006602052604090205490915080821461157f576001600160a01b038416600090815260056020526040812080548490811061152157fe5b906000526020600020015490508060056000876001600160a01b03166001600160a01b03168152602001908152602001600020838154811061155f57fe5b600091825260208083209091019290925591825260069052604090208190555b6001600160a01b03841660009081526005602052604090208054906115a89060001983016119e9565b5050505050565b6001600160a01b0390911660009081526005602081815260408084208054868652600684529185208290559282526001810183559183529091200155565b6001600160a01b03821661160057600080fd5b611609816110e1565b1561161357600080fd5b600081815260016020908152604080832080546001600160a01b0319166001600160a01b038716908117909155835260039091529020611652906117e0565b60405181906001600160a01b038416906000907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908290a45050565b600780546000838152600860205260408120829055600182018355919091527fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c6880155565b6116dc82826117fe565b6000818152600b60205260409020546002600019610100600184161502019091160415611191576000818152600b6020526040812061119191611a0d565b611724828261126c565b1561172e57600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b61175d828261126c565b61176657600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19169055565b3b151590565b6000818152600260205260409020546001600160a01b031615610cf757600090815260026020526040902080546001600160a01b0319169055565b80546117dc90600163ffffffff6117e916565b9055565b80546001019055565b6000828211156117f857600080fd5b50900390565b611808828261182a565b61181282826114ba565b600081815260066020526040812055611191816118cf565b816001600160a01b031661183d82610dc8565b6001600160a01b03161461185057600080fd5b6118598161178e565b6001600160a01b038216600090815260036020526040902061187a906117c9565b60008181526001602052604080822080546001600160a01b0319169055518291906001600160a01b038516907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908390a45050565b6007546000906118e690600163ffffffff6117e916565b6000838152600860205260408120546007805493945090928490811061190857fe5b90600052602060002001549050806007838154811061192357fe5b600091825260208083209091019290925582815260089091526040902082905560078054906119569060001983016119e9565b50505060009182525060086020526040812055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106119ac57805160ff19168380011785556119d9565b828001600101855582156119d9579182015b828111156119d95782518255916020019190600101906119be565b506119e5929150611a4d565b5090565b815481835581811115610b7957600083815260209020610b79918101908301611a4d565b50805460018160011615610100020316600290046000825580601f10611a335750610cf7565b601f016020900490600052602060002090810190610cf791905b6109e791905b808211156119e55760008155600101611a5356fea165627a7a72305820293302eacf6dcb62c9949ea1eaa0c4cd83ae3b2733a42e8d56a5fde394bd118f0029";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_ZIPCODETOADRESS = "zipCodeToAdress";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_MINTUNIQUETOKENTO = "mintUniqueTokenTo";

    public static final String FUNC_ZIPCODETOADDRESS = "zipCodeToAddress";

    public static final String FUNC_TOKENOFOWNERBYINDEX = "tokenOfOwnerByIndex";

    public static final String FUNC_SETZIPCODETOADDRESS = "setZipCodeToAddress";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_SAFETRANSFERFROM = "safeTransferFrom";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_MINTTOZIPCODE = "mintToZipCode";

    public static final String FUNC_TOKENBYINDEX = "tokenByIndex";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_ADDMINTER = "addMinter";

    public static final String FUNC_RENOUNCEMINTER = "renounceMinter";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_ISMINTER = "isMinter";

    public static final String FUNC_TOKENURI = "tokenURI";

    public static final String FUNC_BALANCEOFZIPCODE = "balanceOfZipCode";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final Event MINTERADDED_EVENT = new Event("MinterAdded", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event MINTERREMOVED_EVENT = new Event("MinterRemoved", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected MyGvo(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyGvo(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MyGvo(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MyGvo(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Boolean> supportsInterface(byte[] interfaceId) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getApproved(BigInteger tokenId) {
        final Function function = new Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new Uint256(tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> approve(String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new Address(to),
                new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> zipCodeToAdress(String zipCode) {
        final Function function = new Function(
                FUNC_ZIPCODETOADRESS, 
                Arrays.<Type>asList(new Utf8String(zipCode)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String from, String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new Address(from),
                new Address(to),
                new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> mintUniqueTokenTo(String _to, BigInteger _tokenId, String _tokenURI) {
        final Function function = new Function(
                FUNC_MINTUNIQUETOKENTO, 
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_tokenId),
                new Utf8String(_tokenURI)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> zipCodeToAddress(byte[] param0) {
        final Function function = new Function(FUNC_ZIPCODETOADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> tokenOfOwnerByIndex(String owner, BigInteger index) {
        final Function function = new Function(FUNC_TOKENOFOWNERBYINDEX, 
                Arrays.<Type>asList(new Address(owner),
                new Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setZipCodeToAddress(String zipCode, String _address) {
        final Function function = new Function(
                FUNC_SETZIPCODETOADDRESS, 
                Arrays.<Type>asList(new Utf8String(zipCode),
                new Address(_address)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> mint(String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new Address(to),
                new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId) {
        final Function function = new Function(
                FUNC_SAFETRANSFERFROM, 
                Arrays.<Type>asList(new Address(from),
                new Address(to),
                new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> burn(BigInteger tokenId) {
        final Function function = new Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> mintToZipCode(String zipCode, BigInteger _tokenId) {
        final Function function = new Function(
                FUNC_MINTTOZIPCODE, 
                Arrays.<Type>asList(new Utf8String(zipCode),
                new Uint256(_tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> tokenByIndex(BigInteger index) {
        final Function function = new Function(FUNC_TOKENBYINDEX, 
                Arrays.<Type>asList(new Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> ownerOf(BigInteger tokenId) {
        final Function function = new Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new Uint256(tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> balanceOf(String owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new Address(owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> addMinter(String account) {
        final Function function = new Function(
                FUNC_ADDMINTER, 
                Arrays.<Type>asList(new Address(account)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> renounceMinter() {
        final Function function = new Function(
                FUNC_RENOUNCEMINTER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setApprovalForAll(String to, Boolean approved) {
        final Function function = new Function(
                FUNC_SETAPPROVALFORALL, 
                Arrays.<Type>asList(new Address(to),
                new Bool(approved)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isMinter(String account) {
        final Function function = new Function(FUNC_ISMINTER, 
                Arrays.<Type>asList(new Address(account)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId, byte[] _data) {
        final Function function = new Function(
                FUNC_SAFETRANSFERFROM, 
                Arrays.<Type>asList(new Address(from),
                new Address(to),
                new Uint256(tokenId),
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> tokenURI(BigInteger tokenId) {
        final Function function = new Function(FUNC_TOKENURI, 
                Arrays.<Type>asList(new Uint256(tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> balanceOfZipCode(String zipCode) {
        final Function function = new Function(
                FUNC_BALANCEOFZIPCODE, 
                Arrays.<Type>asList(new Utf8String(zipCode)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isApprovedForAll(String owner, String operator) {
        final Function function = new Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new Address(owner),
                new Address(operator)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public List<MinterAddedEventResponse> getMinterAddedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(MINTERADDED_EVENT, transactionReceipt);
        ArrayList<MinterAddedEventResponse> responses = new ArrayList<MinterAddedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            MinterAddedEventResponse typedResponse = new MinterAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MinterAddedEventResponse> minterAddedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, MinterAddedEventResponse>() {
            @Override
            public MinterAddedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(MINTERADDED_EVENT, log);
                MinterAddedEventResponse typedResponse = new MinterAddedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MinterAddedEventResponse> minterAddedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINTERADDED_EVENT));
        return minterAddedEventFlowable(filter);
    }

    public List<MinterRemovedEventResponse> getMinterRemovedEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(MINTERREMOVED_EVENT, transactionReceipt);
        ArrayList<MinterRemovedEventResponse> responses = new ArrayList<MinterRemovedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            MinterRemovedEventResponse typedResponse = new MinterRemovedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MinterRemovedEventResponse> minterRemovedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, MinterRemovedEventResponse>() {
            @Override
            public MinterRemovedEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(MINTERREMOVED_EVENT, log);
                MinterRemovedEventResponse typedResponse = new MinterRemovedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MinterRemovedEventResponse> minterRemovedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINTERREMOVED_EVENT));
        return minterRemovedEventFlowable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public List<ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ApprovalForAllEventResponse>() {
            @Override
            public ApprovalForAllEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVALFORALL_EVENT, log);
                ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
        return approvalForAllEventFlowable(filter);
    }

    @Deprecated
    public static MyGvo load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyGvo(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MyGvo load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyGvo(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MyGvo load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MyGvo(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MyGvo load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MyGvo(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MyGvo> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyGvo.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<MyGvo> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyGvo.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyGvo> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyGvo.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyGvo> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyGvo.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class MinterAddedEventResponse {
        public Log log;

        public String account;
    }

    public static class MinterRemovedEventResponse {
        public Log log;

        public String account;
    }

    public static class TransferEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger tokenId;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class ApprovalForAllEventResponse {
        public Log log;

        public String owner;

        public String operator;

        public Boolean approved;
    }
}
