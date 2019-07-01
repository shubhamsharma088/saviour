# saviour


This project aims to scan **torpedos** and **HPShips** from 100x100 data file.

## Torpedo Image

```

     +
     +
    +++
  +++++++
  ++   ++
 ++  +  ++
 ++ +++ ++
 ++  +  ++
  ++   ++
  +++++++
    +++


```
## HPShip Image

```
              
  ++++++++++  
 ++        ++ 
  ++++++++++  
      ++      
      ++      
      ++      
  ++++++++++  
 ++        ++ 
  ++++++++++  
              
```

## Methodology Used:

We fisrt convert all the data into matrix of relavant sizes example:
- Data Matrix - 100x100
- HPTorpedoMatrix - 11x9


Then We overlay the pattern to be detected on the Data Matrix to find all the matched using **scanDataForEnemies** operation. 

We then try to find out top enemies(torpedo/hpShips) based on accuracy of match, which is nothing but
 ``` 
 (number of match*100)/total comparisons 
 ```

 Once the list of enemies is sorted based on accuracy, we remove overlapping matches using **removeOverlaps** method.
 And then we fetch torpedos/hsShip with highest match percentage using **getTopEnemies** method

