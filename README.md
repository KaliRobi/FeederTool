The aim is to automate the following task:
A target app can process/reprocess entities failed on a node. An automation script looks for these failed process instances and sends a list to the team.
The production version of the tool feeds back the list entires to the target app saving the repetative processing steps and manual inspection. 
If, after this porcess, the instance fails again the target app lists them separately.
Additionaly the tool helps us to see tendecies of the failed instances using Chart.js on the front (this is not up there as it is also needs to be changed a bit).

Important to mention that due to safety reasons (to remove anything compnay specific) this version is much more for presentation than for demonstration.
