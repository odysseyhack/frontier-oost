# Asset Monitoring Service (AMS), Ethereum Smart contracts and python satellite web service

Part 1 for AMS. Part 2 for deploying Smart Contracts. Part 3 for interacting with the Smart Contract (after part 2). Part 4 for the Sarvision Satellite (web)Service. Part 1, 2, 3 and 4, 5 for creating a complete working AMS application that has an interactable connection with the Smart Contracts. Including (J)Unit tests.

## dependencies

-The AMS project is made with (java) Spring Boot and is configured with a local PostgreSQL db. You should install PostgreSQL first, before running the application.
-The Smart Contracts are made with Truffle + Ganache + Web3.
-The SarvisionSatelliteService uses python(3).

## PART 1. How to run with PostgreSQL WITHOUT smart contract connection

This is without the connection to the smart contract. Loads a loan and asset as dummy data by default.

1.  (git (if you have your topicus stash account configured with git)) clone https://stash.topicus.nl/projects/FBL/repos/graduation-iot-monitoring/
2.  Install PostgreSQL
3.  Configure username, password, local database
4.  In '/src/main/resources/application.properties' configure your db from step 3
5.  run 'graduation-iot-monitoring/src/main/java/nl/topicus/roelvanwely/ams/AssetMonitoringServiceApplication.java'
6.  Verify in browser: localhost:8080

## PART 2. How to run with PostgreSQL or skip it & deploy Smart Contract(s) using Truffle

With PostgreSQL and smart contract deployed through running a local blockchain RPC server (Ganache).

7.  Execute step 1-4 of above 'PART 1'. NOTE: Skip this step if you only want to deploy the SC's
8.  (git (if you have your topicus stash account configured with git)) clone https://stash.topicus.nl/projects/FBL/repos/graduation-iot-and-blockchain
9.  run `cd graduation-iot-and-blockchain`
10. run `npm install` to install dependencies
11. Download and install Ganache. Either the CLI or the GUI. (https://truffleframework.com/docs/ganache/overview for both GUI and CLI install instructions)
12. Start Ganache/Ganache-cli
13. Be sure you're connected to an Ethereum client (Ganache) before running the commands below. (see https://truffleframework.com/docs/truffle/getting-started/running-migrations for more information)
14. NOTE: only if you changed the smart contract. Otherwise it's already compiled and you can skip this step. run `truffle compile` to compile the smart contract(s).
15. run `truffle migrate` to deploy contracts. If it fails on a 'Error: Attempting to run transaction which calls a contract function, but recipient address 0x... is not a contract address' run `truffle migrate --reset`.
16. Verify console output on success before preceding and save the contract deployed addresses for BasecContract and AssetMonitoringContract (0x.....).

## PART 3. Interacting with the Smart Contract(s) with Truffle

This is the part where you will be able to interact with the smart contract(s). E.g. creating assets, which will be used(loaded) in the AMS.

17. Execute all steps of above 'PART 2'
18. run `truffle console` (see https://truffleframework.com/docs/truffle/getting-started/interacting-with-your-contracts for more information).
19. Create a BaseContract instance and save to variable to interact with SC: run inside truffle console `let baseContractInstance = await BaseContract.at("0x1234...")` you have to replace the "0x1234..." with the address of the deployed BaseContract (step 15 of PART 2).
20. run `baseContractInstance` to verify instance and see available functions. E.g. "createAsset(string)"
21. run `baseContractInstance <function(param)>` to make calls to the SC. E.g.: `baseContractInstance.createAsset("asset_123")`

## PART 4. Launching the python Sarvision Satellite Service web service

This is the part that will launch a python web service that is responsible for getting satellite data of gps-coordinate defined assets in the AMS.

22. (git (if you have your topicus stash account configured with git)) clone https://stash.topicus.nl/projects/FBL/repos/fyndoo-iot-sensors/
23. run `cd fyndoo-iot-sensors/SatteliteSarvisionConverterApp`
24. install python3 https://www.python.org/
25. run `python3 SarvisionSatelliteService.py`
26. Might get some missing dependencie(s) errors. Install missing dependencies using python3 -m pip install <dependency>. E.g.: python3 -m pip install opencv-python
27. Repeat 25-26 until successful launched and 'Running on http://127.0.0.1:5000/' showing in console.

## PART 5. Connecting PART 1, 2, 3 (and 4)

This part will connect all dots and make a complete operating application with blockchain interaction

28. Execute at least 'PART 1, 2, 4' and 'PART 3' if you want to create test data e.g. creating assets and milestones.
29. Copy the addresses of 'part 2' step 15 and paste them in 'graduation-iot-monitoring/src/main/java/nl/topicus/roelvanwely/ams/system/AscLoader.java' under 'ETH_BASE_CONTRACT_ADDRESS' and 'ETH_ASSET_MONITORING_CONTRACT_ADDRESS'.
30. Run step 5-6 of 'PART 1'
31. You will get an error in the console, if the connection to the smart contract(s) will fail.

## Running JUnit tests of AssetMonitoringService

1.  Run `mvn test` within AMS directory console to execute the JUnit tests

## Running unit tests of SC's

1.  Run `truffle test` within graduation-iot-and-blockchain directory console to run unit tests

## Contributors

Contact (in the same order) one of the following users for further help.

1.  [Roel van Wely](https://stash.topicus.nl/users/Roel.van.Wely) for questions related to part 1, 2, 3, 4 and 5
2.  [Ramon Ankersmit](https://stash.topicus.nl/users/Ramon.Ankersmit) for questions related to part 4
3.  [Michel Brinkhuis](https://stash.topicus.nl/users/Michel.Brinkhuis) for questions related to part 2 and 3
4.  [Frank Brinkkemper](https://stash.topicus.nl/users/Frank.Brinkkemper) for questions related to part 2 and 3
