# Fusion
fusion implementation

# Generate fsp file
```
 fusion subgraph pack -s ./subgraph/employee-service/schema.graphqls -w ./subgraph/employee-service
```
# Generate fgp file
```
fusion compose -p ./supergraph/gateway -s ./subgraph/employee-service
```
