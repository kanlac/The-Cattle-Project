//user: neo4j
//password: 123456

CREATE (a:Cattle {sex:'male', birthday:20150307, weight:23.4}),
       (b:Cattle {sex:'female', birthday:20150407, weight:24.4}),
       (c:Cattle {sex:'female', birthday:20160308, weight:30}),
       (d:Cattle {sex:'male', birthday:20150307, weight:23.4}),
       (e:Cattle {sex:'female', birthday:20150307, weight:23.4}),
       (f:Cattle {sex:'male', birthday:20190310, weight:32.7}),
       (g:Cattle {sex:'male', birthday:20150910, weight:12.7}),
       (h:Cattle {sex:'male', birthday:20190313, weight:30.7}),
       (i:Cattle {sex:'female', birthday:20190318, weight:32.7}),
       (a)-[:CHILD]->(c),
       (a)-[:CHILD]->(d),
       (b)-[:CHILD]->(c),
       (b)-[:CHILD]->(d),
       (b)-[:CHILD]->(h),
       (c)-[:CHILD]->(e),
       (c)-[:CHILD]->(f),
       (d)-[:CHILD]->(e),
       (g)-[:CHILD]->(h),
       (h)-[:CHILD]->(i),
       (e)-[:CHILD]->(i)

CREATE (:Admin {name:'吴', password:'655', position:'经理', phone:'123456'})


// return all nodes
MATCH (n)
RETURN n;

// delete all nodes labeled Cattle
MATCH (del:Cattle)
DETACH DELETE del

// delete by id
MATCH (del:Cattle) WHERE ID(del) = 22
DETACH DELETE del

// check login
MATCH (u:Admin) WHERE u.name = '吴' AND u.password = '655' RETURN u