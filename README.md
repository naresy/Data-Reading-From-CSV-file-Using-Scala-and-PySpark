<header>
<h1>Quantexa Assignment Project</h1>
</header>

<section>
<h2>Introduction</h2>
<p>This project uses Scala and Apache Spark to analyze flight and passenger data, producing various statistics such as flights per month, frequent flyers, country visits, and more.</p>
</section>

<section>
<h2>Prerequisites</h2>
<ul>
<li>Java JDK 8 or higher</li>
<li>Scala 2.12.x</li>
<li>Apache Spark 3.x</li>
<li>SBT (Scala Build Tool)</li>
</ul>
</section>
<section>
<h2>Installation</h2>
<p>Clone the repository and navigate into the project directory:</p>
<pre><code>git clone https://github.com/naresy/QuantexaAssignment.git
  <br>
  cd QuantexaAssignment</code></pre>
</section>
<section>
<h2>Project Structure</h2>
<ul>
<li><code>src/main/scala/Main.scala</code> - Main application file.</li>
<li><code>src/main/scala/DataLoader.scala</code> - Loads the CSV data.</li>
<li><code>src/main/scala/FlightStatistics.scala</code> - Computes flight statistics.</li>
<li><code>src/main/resources/</code> - Contains input CSV files.</li>
</ul>
</section>
<section>
<h2>Build Setup</h2>
<p>Ensure the correct versions of Scala and Spark are used. The project settings are as follows:</p>
<pre><code>ThisBuild / version := "0.1.0-SNAPSHOT"<br>
ThisBuild / scalaVersion := "2.13.12"<br><br>
lazy val root = (project in file("."))
  .settings(
    name := "QuantexaAssignment",
    idePackagePrefix := Some("com.naresh.spark")
  )<br><br>
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.5.0",
  "org.apache.spark" %% "spark-sql" % "3.5.0"
)</code></pre>
</section>

<section>
  <h2>Usage</h2>
  <p>Run the project with SBT:</p>
  <pre><code>sbt run</code></pre>
  <p>This will calculate the statistics and save them as text files in the output directory.</p>
</section>

<section>
<h2>Example Data</h2>
<p>Place your CSV files in the <code>src/main/resources/</code> directory. Example data includes:</p>
<ul>
<li><code>flights.csv</code> - Contains flight information.</li>
<li><code>passengers.csv</code> - Contains passenger information.</li>
</ul>
</section>
<section>
<h2>Extending the Project</h2>
<p>To extend the project:</p>
  <ol>
  <li>Add new data processing modules in the <code>src/main/scala/</code> directory.</li>
  <li>Update the <code>Main.scala</code> file to include the new module in the processing pipeline.</li>
  <li>Ensure any new dependencies are added to <code>build.sbt</code>.</li>
  </ol>
  </section>

<section>
<h2>Troubleshooting</h2>
<ul>
<li>Ensure that all prerequisites are installed and correctly configured.</li>
<li>If you encounter memory issues, consider increasing the driver's memory allocation with <code>--driver-memory</code> in your SBT run command.</li>
</ul>
</section>
<section>
<h2>License</h2>
<p>This project is licensed under the MIT License - see the <a href="LICENSE">LICENSE</a> file for details.</p>
</section>
<section>
<h2>Acknowledgments</h2>
<p>Thanks to Quantexa for the assignment opportunity.
  <br>
Apache Spark for providing the processing framework.</p>
</section>
<section>
<h2>Contact</h2>
<p>For any issues or queries, contact Naresh at <a href="mailto:info.naresh74@gmail.com">info.naresh74@gmail.com</a>.</p>
</section>
<section>
<section>
<h2>Screenshots</h2>
<p>Here are the come screen Shot of the Outpu</p>

<p align="center">
  <img src="https://github.com/naresy/QuantexaAssignment/blob/master/sc1.png?text=Screenshot+1" alt="Screenshot 1" width="300"/>
  <img src="https://github.com/naresy/QuantexaAssignment/blob/master/sc2.png?text=Screenshot+2" alt="Screenshot 2" width="300"/>
  <img src="https://github.com/naresy/QuantexaAssignment/blob/master/sc3.png?text=Screenshot+3" alt="Screenshot 3" width="300"/>
   <img src="https://github.com/naresy/QuantexaAssignment/blob/master/sc3.png?text=Screenshot+3" alt="Screenshot 3" width="300"/>
   <img src="https://github.com/naresy/QuantexaAssignment/blob/master/sc3.png?text=Screenshot+3" alt="Screenshot 3" width="300"/>
</p>
<footer>
<p>&copy; 2024. All rights reserved.</p>
</footer>

