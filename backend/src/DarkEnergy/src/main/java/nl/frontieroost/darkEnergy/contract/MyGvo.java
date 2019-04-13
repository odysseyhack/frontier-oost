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
    private static final String BINARY = "60806040523480156200001157600080fd5b506040518060400160405280600581526020017f4d7947766f0000000000000000000000000000000000000000000000000000008152506040518060400160405280600481526020017f4d47564f000000000000000000000000000000000000000000000000000000008152508181620000986301ffc9a760e01b6200012760201b60201c565b620000b06380ac58cd60e01b6200012760201b60201c565b620000c863780e9d6360e01b6200012760201b60201c565b8151620000dd9060099060208501906200025e565b508051620000f390600a9060208401906200025e565b506200010c635b5e139f60e01b6200012760201b60201c565b5050505062000121336200019460201b60201c565b62000303565b7fffffffff0000000000000000000000000000000000000000000000000000000080821614156200015757600080fd5b7fffffffff00000000000000000000000000000000000000000000000000000000166000908152602081905260409020805460ff19166001179055565b620001af81600c620001e660201b6200118d1790919060201c565b6040516001600160a01b038216907f6ae172837ea30b801fbfcdd4108aa1d5bf8ff775444fd70256b44e6bf3dfc3f690600090a250565b620001f882826200022860201b60201c565b156200020357600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b60006001600160a01b0382166200023e57600080fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620002a157805160ff1916838001178555620002d1565b82800160010185558215620002d1579182015b82811115620002d1578251825591602001919060010190620002b4565b50620002df929150620002e3565b5090565b6200030091905b80821115620002df5760008155600101620002ea565b90565b61150680620003136000396000f3fe608060405234801561001057600080fd5b50600436106101425760003560e01c80634f6ccce7116100b8578063986502751161007c57806398650275146104aa578063a22cb465146104b2578063aa271e1a146104e0578063b88d4fde14610506578063c87b56dd146105cc578063e985e9c5146105e957610142565b80634f6ccce71461041c5780636352211e1461043957806370a082311461045657806395d89b411461047c578063983b2d561461048457610142565b806323b872dd1161010a57806323b872dd1461028057806326dd860a146102b65780632f745c591461037157806340c10f191461039d57806342842e0e146103c957806342966c68146103ff57610142565b806301ffc9a71461014757806306fdde0314610182578063081812fc146101ff578063095ea7b31461023857806318160ddd14610266575b600080fd5b61016e6004803603602081101561015d57600080fd5b50356001600160e01b031916610617565b604080519115158252519081900360200190f35b61018a610636565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101c45781810151838201526020016101ac565b50505050905090810190601f1680156101f15780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61021c6004803603602081101561021557600080fd5b50356106cd565b604080516001600160a01b039092168252519081900360200190f35b6102646004803603604081101561024e57600080fd5b506001600160a01b0381351690602001356106fd565b005b61026e6107aa565b60408051918252519081900360200190f35b6102646004803603606081101561029657600080fd5b506001600160a01b038135811691602081013590911690604001356107b0565b610264600480360360608110156102cc57600080fd5b6001600160a01b03823516916020810135918101906060810160408201356401000000008111156102fc57600080fd5b82018360208201111561030e57600080fd5b8035906020019184600183028401116401000000008311171561033057600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506107d3945050505050565b61026e6004803603604081101561038757600080fd5b506001600160a01b0381351690602001356107e7565b61016e600480360360408110156103b357600080fd5b506001600160a01b038135169060200135610834565b610264600480360360608110156103df57600080fd5b506001600160a01b0381358116916020810135909116906040013561085b565b6102646004803603602081101561041557600080fd5b5035610876565b61026e6004803603602081101561043257600080fd5b5035610895565b61021c6004803603602081101561044f57600080fd5b50356108c9565b61026e6004803603602081101561046c57600080fd5b50356001600160a01b03166108f1565b61018a610927565b6102646004803603602081101561049a57600080fd5b50356001600160a01b0316610988565b6102646109a3565b610264600480360360408110156104c857600080fd5b506001600160a01b03813516906020013515156109ae565b61016e600480360360208110156104f657600080fd5b50356001600160a01b0316610a32565b6102646004803603608081101561051c57600080fd5b6001600160a01b0382358116926020810135909116916040820135919081019060808101606082013564010000000081111561055757600080fd5b82018360208201111561056957600080fd5b8035906020019184600183028401116401000000008311171561058b57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610a45945050505050565b61018a600480360360208110156105e257600080fd5b5035610a6b565b61016e600480360360408110156105ff57600080fd5b506001600160a01b0381358116916020013516610b1e565b6001600160e01b03191660009081526020819052604090205460ff1690565b60098054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156106c25780601f10610697576101008083540402835291602001916106c2565b820191906000526020600020905b8154815290600101906020018083116106a557829003601f168201915b505050505090505b90565b60006106d882610b4c565b6106e157600080fd5b506000908152600260205260409020546001600160a01b031690565b6000610708826108c9565b9050806001600160a01b0316836001600160a01b0316141561072957600080fd5b336001600160a01b038216148061074557506107458133610b1e565b61074e57600080fd5b60008281526002602052604080822080546001600160a01b0319166001600160a01b0387811691821790925591518593918516917f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92591a4505050565b60075490565b6107ba3382610b69565b6107c357600080fd5b6107ce838383610bc8565b505050565b6107dd8383610be7565b6107ce8282610c08565b60006107f2836108f1565b82106107fd57600080fd5b6001600160a01b038316600090815260056020526040902080548390811061082157fe5b9060005260206000200154905092915050565b600061083f33610a32565b61084857600080fd5b6108528383610be7565b50600192915050565b6107ce83838360405180602001604052806000815250610a45565b6108803382610b69565b61088957600080fd5b61089281610c39565b50565b600061089f6107aa565b82106108aa57600080fd5b600782815481106108b757fe5b90600052602060002001549050919050565b6000818152600160205260408120546001600160a01b0316806108eb57600080fd5b92915050565b60006001600160a01b03821661090657600080fd5b6001600160a01b03821660009081526003602052604090206108eb90610c4b565b600a8054604080516020601f60026000196101006001881615020190951694909404938401819004810282018101909252828152606093909290918301828280156106c25780601f10610697576101008083540402835291602001916106c2565b61099133610a32565b61099a57600080fd5b61089281610c4f565b6109ac33610c97565b565b6001600160a01b0382163314156109c457600080fd5b3360008181526004602090815260408083206001600160a01b03871680855290835292819020805460ff1916861515908117909155815190815290519293927f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31929181900390910190a35050565b60006108eb600c8363ffffffff610cdf16565b610a508484846107b0565b610a5c84848484610d14565b610a6557600080fd5b50505050565b6060610a7682610b4c565b610a7f57600080fd5b6000828152600b602090815260409182902080548351601f600260001961010060018616150201909316929092049182018490048402810184019094528084529091830182828015610b125780601f10610ae757610100808354040283529160200191610b12565b820191906000526020600020905b815481529060010190602001808311610af557829003601f168201915b50505050509050919050565b6001600160a01b03918216600090815260046020908152604080832093909416825291909152205460ff1690565b6000908152600160205260409020546001600160a01b0316151590565b600080610b75836108c9565b9050806001600160a01b0316846001600160a01b03161480610bb05750836001600160a01b0316610ba5846106cd565b6001600160a01b0316145b80610bc05750610bc08185610b1e565b949350505050565b610bd3838383610e4d565b610bdd8382610f2d565b6107ce8282611022565b610bf18282611060565b610bfb8282611022565b610c0481611101565b5050565b610c1182610b4c565b610c1a57600080fd5b6000828152600b6020908152604090912082516107ce928401906113de565b610892610c45826108c9565b82611145565b5490565b610c60600c8263ffffffff61118d16565b6040516001600160a01b038216907f6ae172837ea30b801fbfcdd4108aa1d5bf8ff775444fd70256b44e6bf3dfc3f690600090a250565b610ca8600c8263ffffffff6111c616565b6040516001600160a01b038216907fe94479a9f7e1952cc78f2d6baab678adc1b772d936c6583def489e524cb6669290600090a250565b60006001600160a01b038216610cf457600080fd5b506001600160a01b03166000908152602091909152604090205460ff1690565b6000610d28846001600160a01b03166111fb565b610d3457506001610bc0565b604051600160e11b630a85bd0102815233600482018181526001600160a01b03888116602485015260448401879052608060648501908152865160848601528651600095928a169463150b7a029490938c938b938b939260a4019060208501908083838e5b83811015610db1578181015183820152602001610d99565b50505050905090810190601f168015610dde5780820380516001836020036101000a031916815260200191505b5095505050505050602060405180830381600087803b158015610e0057600080fd5b505af1158015610e14573d6000803e3d6000fd5b505050506040513d6020811015610e2a57600080fd5b50516001600160e01b031916600160e11b630a85bd010214915050949350505050565b826001600160a01b0316610e60826108c9565b6001600160a01b031614610e7357600080fd5b6001600160a01b038216610e8657600080fd5b610e8f81611201565b6001600160a01b0383166000908152600360205260409020610eb09061123c565b6001600160a01b0382166000908152600360205260409020610ed190611253565b60008181526001602052604080822080546001600160a01b0319166001600160a01b0386811691821790925591518493918716917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef91a4505050565b6001600160a01b038216600090815260056020526040812054610f5790600163ffffffff61125c16565b600083815260066020526040902054909150808214610ff2576001600160a01b0384166000908152600560205260408120805484908110610f9457fe5b906000526020600020015490508060056000876001600160a01b03166001600160a01b031681526020019081526020016000208381548110610fd257fe5b600091825260208083209091019290925591825260069052604090208190555b6001600160a01b038416600090815260056020526040902080549061101b90600019830161145c565b5050505050565b6001600160a01b0390911660009081526005602081815260408084208054868652600684529185208290559282526001810183559183529091200155565b6001600160a01b03821661107357600080fd5b61107c81610b4c565b1561108657600080fd5b600081815260016020908152604080832080546001600160a01b0319166001600160a01b0387169081179091558352600390915290206110c590611253565b60405181906001600160a01b038416906000907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908290a45050565b600780546000838152600860205260408120829055600182018355919091527fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c6880155565b61114f8282611271565b6000818152600b60205260409020546002600019610100600184161502019091160415610c04576000818152600b60205260408120610c0491611480565b6111978282610cdf565b156111a157600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19166001179055565b6111d08282610cdf565b6111d957600080fd5b6001600160a01b0316600090815260209190915260409020805460ff19169055565b3b151590565b6000818152600260205260409020546001600160a01b03161561089257600090815260026020526040902080546001600160a01b0319169055565b805461124f90600163ffffffff61125c16565b9055565b80546001019055565b60008282111561126b57600080fd5b50900390565b61127b828261129d565b6112858282610f2d565b600081815260066020526040812055610c0481611342565b816001600160a01b03166112b0826108c9565b6001600160a01b0316146112c357600080fd5b6112cc81611201565b6001600160a01b03821660009081526003602052604090206112ed9061123c565b60008181526001602052604080822080546001600160a01b0319169055518291906001600160a01b038516907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908390a45050565b60075460009061135990600163ffffffff61125c16565b6000838152600860205260408120546007805493945090928490811061137b57fe5b90600052602060002001549050806007838154811061139657fe5b600091825260208083209091019290925582815260089091526040902082905560078054906113c990600019830161145c565b50505060009182525060086020526040812055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061141f57805160ff191683800117855561144c565b8280016001018555821561144c579182015b8281111561144c578251825591602001919060010190611431565b506114589291506114c0565b5090565b8154818355818111156107ce576000838152602090206107ce9181019083016114c0565b50805460018160011615610100020316600290046000825580601f106114a65750610892565b601f01602090049060005260206000209081019061089291905b6106ca91905b8082111561145857600081556001016114c656fea165627a7a72305820074ecbcf05dabb89e04b620effc575e6679baa509ed21f3eb159ea85154d8e290029";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_MINTUNIQUETOKENTO = "mintUniqueTokenTo";

    public static final String FUNC_TOKENOFOWNERBYINDEX = "tokenOfOwnerByIndex";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_SAFETRANSFERFROM = "safeTransferFrom";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_TOKENBYINDEX = "tokenByIndex";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_ADDMINTER = "addMinter";

    public static final String FUNC_RENOUNCEMINTER = "renounceMinter";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_ISMINTER = "isMinter";

    public static final String FUNC_TOKENURI = "tokenURI";

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

    public RemoteCall<BigInteger> tokenOfOwnerByIndex(String owner, BigInteger index) {
        final Function function = new Function(FUNC_TOKENOFOWNERBYINDEX, 
                Arrays.<Type>asList(new Address(owner),
                new Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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
