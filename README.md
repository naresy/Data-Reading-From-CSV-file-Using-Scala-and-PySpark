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
        <code>git clone https://github.com/naresy/QuantexaAssignment.git
        <br>cd QuantexaAssignment</code>
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
        <h2>Usage</h2>
        <p>Run the project with SBT:</p>
        <code>sbt run</code>
        <p>This will calculate the statistics and save them as text files in the output directory.</p>
    </section>
   <footer>
        <p>&copy; 2024. All rights reserved.</p>
    </footer>
</body>
</html>
