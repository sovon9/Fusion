# Fusion GraphQL Gateway
This repository contains a Hot Chocolate Fusion GraphQL Gateway.
It composes multiple GraphQL subgraphs (microservices) into a single, unified supergraph that clients query via one endpoint.

## Table of Contents
- What is Fusion?
- Core Concepts
  - Subgraphs, Supergraph, Gateway
- Fusion Artifacts: .fsp and .fgp
  - What is an .fsp file?
  - What is an .fgp file?
  - Role of subgraph-config.json in generating.fsp

### What is Fusion?
Fusion is a feature of the Hot Chocolate GraphQL ecosystem (by ChilliCream) that enables you to compose multiple GraphQL services (subgraphs) into a single unified API (supergraph) without tightly coupling them. Fusion performs query planning across services, joins data using entity keys, and executes sub-requests in parallel where possible, returning one response to the client.

Think of Fusion as:
- A composition engine that understands which fields live in which subgraph.
- A runtime that plans and executes cross-service queries efficiently.
- A developer friendly way to evolve microservices while keeping a single public Graphql schema

### Core Concepts
#### Subgraphs, Supergraphs, Gateway
- Subgraph: A standalone Graphql service exposing of domain (e.g. `employee-service`, `department-service`) Each is having it's own URL and schema
- Supergraph: The composed schema resulting from merging subgraphs. It defines how types and fields are federated/linked across subgraphs.
- Gateway: The server that hosts the supergraph, accepts client queries, plans then against subgraphs, and returns results.

### Fusion Artifacts .fsp and .fgp
Fusion uses intermediate artifacts to secribe subgraph capabilities and the composed gateway plan. you'll see these files in this repo under `subgraph/` and `supergraph/`.

### What is .fsp file ?
- `fsp` stands for Fusion Subgraph Plan.
- it's a representation generated for a subgraph that captures its schema, entity keys and other metadata required by the Gateway to plan queries.
- the `.fsp` file is produced from the subgraph schema and `subgraph-config.json` using Fusion tooling.
### What is .fgp file?
- `.fgp` stands for Fusion Gateway Plan.
- It's the composed artifact the gateway loads at startup. It aggregates all subgraphs.

### Role of subgraph-config.json in generating .fsp
- `subgraph-config.json` describes how to build the `.fsp` for a given subgraph

### Generate fsp file
```
 fusion subgraph pack -s ./subgraph/employee-service/schema.graphqls -w ./subgraph/employee-service
```
### Generate fgp file
```
fusion compose -p ./supergraph/gateway -s ./subgraph/employee-service
```
### Fusion Employee service
`https://github.com/sovon9/Fusion-Employee-Service`

### Fusion Department service
`https://github.com/sovon9/Fusion-Department-Service`