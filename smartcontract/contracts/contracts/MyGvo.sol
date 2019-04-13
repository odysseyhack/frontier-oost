pragma solidity ^0.5.2;


// import "./test.sol";
import "./openzeppelin-solidity/contracts/token/ERC721/ERC721Full.sol";
import "./openzeppelin-solidity/contracts/token/ERC721/ERC721Mintable.sol";
import "./openzeppelin-solidity/contracts/token/ERC721/ERC721Burnable.sol";

contract MyGvo is ERC721Full, ERC721Mintable, ERC721Burnable {
  address private mintingAddress; //contract creator

  mapping (bytes32 => address) public zipCodeToAddress;

  constructor() ERC721Full("MyGvo", "MGVO") public {
    mintingAddress = msg.sender;
  }

  /**
   * Custom accessor to create a unique token
   */
   function mintUniqueTokenTo(address _to, uint256 _tokenId, string memory _tokenURI
   ) public
   {
       super._mint(_to, _tokenId);
       super._setTokenURI(_tokenId, _tokenURI);
   }

   function zipCodeToAdress(string memory zipCode) public returns (address){
     bytes32 hash = keccak256(abi.encodePacked(zipCode));
     return zipCodeToAddress[hash];
  }

  function balanceOfZipCode(string memory zipCode) public returns (uint256){
    bytes32 hash = keccak256(abi.encodePacked(zipCode));
    address location = zipCodeToAddress[hash];
    return super.balanceOf(location);
  }

   function setZipCodeToAddress(string memory zipCode, address _address) public {
     bytes32 hash = keccak256(abi.encodePacked(zipCode));
     zipCodeToAddress[hash] = _address;
  }

   function mintToZipCode(string memory zipCode, uint256 _tokenId) public {
     bytes32 hash = keccak256(abi.encodePacked(zipCode));
     address location = zipCodeToAddress[hash];
     super._mint(location, _tokenId);
  }
}