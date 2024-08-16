<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quantexa Assignment</title>
    <style>
        body { font-family: Arial, sans-serif; line-height: 1.6; padding: 20px; }
        header { background: #f0f0f0; padding: 10px 20px; text-align: center; }
        section { margin-bottom: 20px; }
        h1, h2 { color: #333; }
        code { background: #f4f4f4; padding: 2px 6px; }
    </style>
</head>
<body>
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
        <code>git clone https://github.com/yourusername/QuantexaAssignment.git<br>cd QuantexaAssignment</code>
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
    <section>
        <h2>Output</h2>
        <p>The results are saved in text files within the <code>src/main/output/</code> directory. These include statistics like flights per month, frequent flyers, and more.</p>
    </section>
    <footer>
        <p>&copy; 2024 Quantexa Assignment Project. All rights reserved.</p>
    </footer>
</body>
</html>
