var ConvertLib = artifacts.require("./ConvertLib.sol");
var MyGvo = artifacts.require("./MyGvo.sol");

module.exports = function(deployer) {
  deployer.deploy(ConvertLib);
  deployer.link(ConvertLib, MyGvo);
  deployer.deploy(MyGvo);
};
