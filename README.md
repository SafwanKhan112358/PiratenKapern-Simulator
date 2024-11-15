# Piraten Kapern
  * Author: Safwan Khan
 

## Build and Execution

  * To clean working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar`
    <br> 


## Application Pictures
  ![](https://raw.githubusercontent.com/SafwanKhan112358/PiratenKapern-Simulator/refs/heads/main/Sample%20Simulation.jpeg)  
  <br>
## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| Y   | F01 | In a player's turn, simulate a player's very first roll | D | 01/15/23 | 01/20/23 |
| Y   | F02 | For a player, design a simple playing strategy |  D | 01/18/23  | 01/21/23  |
| Y   | F03 | Simulate a player's turn in a game | D | 01/15/23 | 01/21/23  |
| Y   | F04 | Simulate a game between 2 players and find a winner | D | 01/21/23 | 01/22/23  |
| Y   | F05 | Simulate 42 games (simulation) between 2 players |  D  | 01/22/23 | 01/22/23  |
| Y   | F06 | At End of simulation, print out percentage of wins for the 2 players |  D  | 01/22/23 |  01/22/23 |
| x   | F07 | Design Combinational Point Scoring Mechanism and integrate within simulation |  D  | 01/27/23 | 01/27/23  |
| x   | F08 | For a player, design combinational playing strategy |  D  | 01/28/23 | 01/29/23 |
| x   | F09 | Integrate combinational playing strategy within simulation flow |  D  | 01/28/23 | 01/29/23|
| x   | F10| Through command line, specify players' playing strategy |  D  | 01/28/23 | 01/29/23  |
| x   | F11| Create a Card Deck, comprising of NOP, SeaBattle, and MonkeyBusiness Cards |  D  | 01/29/23 | 01/29/23  |
