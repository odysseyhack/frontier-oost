pragma solidity ^0.5.2;

import 'openzeppelin-solidity/contracts/token/ERC721/ERC721Full.sol';
import 'openzeppelin-solidity/contracts/token/ERC721/ERC721Mintable.sol';
import 'openzeppelin-solidity/contracts/token/ERC721/ERC721Burnable.sol';

contract MyGvo is ERC721Full, ERC721Mintable, ERC721Burnable {
  constructor() ERC721Full("MyGvo", "MGVO") public {
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

}