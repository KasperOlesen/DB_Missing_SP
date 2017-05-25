<!DOCTYPE html>
<html>
  <head>
  </head>
  <body>
<h3> Technical Comparison of an SQL and Graph Database </h3>
<br>
<hr>
<br>
<b>Issues:</b>
<p>I have not managed to import the edges into the MySQL table.</p>
<p>I have tried both to used a query and by using the Table Data Import wizard in the workbench</p>
<p>I have created the tables like this:</p>
CREATE TABLE T_USER(<br>
id int NOT NULL, <br>
name varchar(20), <br>
job varchar(20), <br>
birthday date, <br>
primary key (id) <br>
);

CREATE TABLE T_ENDORSEMENTS ( <br>
    ENDORSED INT NOT NULL, <br>
    ENDORSER INT NOT NULL, <br>
    PRIMARY KEY (ENDORSED , ENDORSER), <br>
    FOREIGN KEY (ENDORSED) <br> 
        REFERENCES T_USER (ID), <br>
    FOREIGN KEY (ENDORSER) <br>
        REFERENCES T_USER (ID) <br>
);
<br>
<p>And tried to import it with: </p>
LOAD DATA LOCAL INFILE 'C:/Users/kAlex/Documents/Neo4j/default.graphdb/import/social_network_edges.csv' <br>
INTO TABLE comparesql.t_endorsements <br>
FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' <br>
LINES TERMINATED BY '\n' <br>
IGNORE 1 LINES <br>
(ENDORSED,ENDORSER) <br>
;

<p>But even though I let it work for +1 hour, it just sits there. So its either crashing at some point or really slow</p>
<p>Even though the import of data didnt work, I have implemented the solutions for the MySQL DB. I just dont have the data.</p>
<p>I will update this repo if i find a solution</p>


<b>Results (only Neo4J):</b>

<table>
 <tr>
<th>Queries stats</th>
<th>Neo4J AVG - </th>
<th>Neo4J Median - </th>
<th>MySQL AVG - </th>
<th>MySQL Median</th>
</tr>
<tr>
<td>Depth One</<td>
<td>0.013799998</<td>
<td>0.013</<td>
<td></<td>
<td></<td>

</tr>
<tr>
<td>Depth Two</<td>
<td>0.016750002</<td>
<td>0.016</<td>
<td></<td>
<td></<td>
</tr>
<tr>
<td>Depth Three</<td>
<td>0.0151499985</<td>
<td>0.014</<td>
<td></<td>
<td></<td>
</tr>
<tr>
<td>Depth Four</<td>
<td>0.01685</<td>
<td>0.0155</<td>
<td></<td>
<td></<td>
</tr>
<tr>
<td>Depth Five</<td>
<td>0.044999994</<td>
<td>0.0155</<td>
<td></<td>
<td></<td>
</tr>
</table>
<br>
<table>
<tr>
<th>Queries times</th>
<th>Neo4J</th>
<th>MySQL</th>
</tr>
<tr>
<td>Depth One</td>
<td>
<ul>
<li>0.013</li>
<li>0.013</li>
<li>0.015</li>
<li>0.014</li>
<li>0.014</li>
<li>0.013</li>
<li>0.013</li>
<li>0.014</li>
<li>0.013</li>
<li>0.017</li>
<li>0.02</li>
<li>0.013</li>
<li>0.013</li>
<li>0.014</li>
<li>0.013</li>
<li>0.013</li>
<li>0.013</li>
<li>0.012</li>
<li>0.014</li>
<li>0.012</li>
</ul>
</td>
<td>
<ul>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
</ul>
</<td>


</tr>
<tr>
<td>Depth Two</td>
<td>
<ul>
<li>0.018</li>
<li>0.026</li>
<li>0.014</li>
<li>0.017</li>
<li>0.015</li>
<li>0.014</li>
<li>0.017</li>
<li>0.023</li>
<li>0.015</li>
<li>0.02</li>
<li>0.017</li>
<li>0.013</li>
<li>0.019</li>
<li>0.013</li>
<li>0.013</li>
<li>0.019</li>
<li>0.023</li>
<li>0.013</li>
<li>0.013</li>
<li>0.013</li>
</ul>
</td>
<td>
<ul>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
</ul>
</td>

</tr>
<tr>
<td>Depth Three</td>
<td>
<ul>
<li>0.015</li>
<li>0.014</li>
<li>0.014</li>
<li>0.014</li>
<li>0.014</li>
<li>0.014</li>
<li>0.023</li>
<li>0.014</li>
<li>0.017</li>
<li>0.015</li>
<li>0.014</li>
<li>0.013</li>
<li>0.013</li>
<li>0.013</li>
<li>0.013</li>
<li>0.016</li>
<li>0.015</li>
<li>0.014</li>
<li>0.015</li>
<li>0.023</li>
</ul>
</td>
<td>
<ul>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
</ul>
</td>



</tr>
<tr>
<td>Depth Four</td>
<td>
<ul>
<li>0.015</li>
<li>0.014</li>
<li>0.014</li>
<li>0.017</li>
<li>0.015</li>
<li>0.017</li>
<li>0.027</li>
<li>0.016</li>
<li>0.016</li>
<li>0.021</li>
<li>0.013</li>
<li>0.013</li>
<li>0.016</li>
<li>0.025</li>
<li>0.014</li>
<li>0.027</li>
<li>0.016</li>
<li>0.015</li>
<li>0.013</li>
</ul>
</td>
<td>
<ul>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
</ul>
</td>

</tr>
<tr>
<td>Depth Five</td>
<td>
<ul>
<li>0.402</li>
<li>0.051</li>
<li>0.017</li>
<li>0.016</li>
<li>0.028</li>
<li>0.018</li>
<li>0.156</li>
<li>0.015</li>
<li>0.014</li>
<li>0.014</li>
<li>0.014</li>
<li>0.015</li>
<li>0.014</li>
<li>0.014</li>
<li>0.025</li>
<li>0.019</li>
<li>0.025</li>
<li>0.014</li>
<li>0.015</li>
<li>0.014</li>
</ul>
</td>
<td>
<ul>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
</ul>
</td>
</tr>
</table>
</body>