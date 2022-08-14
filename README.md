## _SalesTaxesProject_
SalesTaxesProject generates the receipt for purchased items, containing the list of products, their bills, sales taxes, and the total bill. It offers you the option to select products from a list of products and produces the receipt for it.

## How to run:
You can clone or download the project in your local repository, and run it in any IDE. Also, you can find the jar file `SalesTaxesProject.jar` in the location: [out/artifacts/SalesTaxesProject_jar](https://github.com/farhin105/SalesTaxesProject/tree/main/out/artifacts/SalesTaxesProject_jar)
You can download the jar file and run it from the command line.
To run the jar file, execute the following in your command prompt,
```sh
java -jar SalesTaxesProject.jar
```
from the file location.
All the logs will be saved in your local `C:\apps\logs` directory.

## How to use:
Upon running the project, it presents a list of product descriptions (which was provided in the problem statement file) and their corresponding numbers. To select a product you have to input the number for that product. If you are done and want to generate the receipt, you have to enter `0` (zero). The program will also instruct you through the process. 
You can enter `y` to continue shopping, or enter any other key to terminate the program.

## Technical Aspects:
- Maven for dependency management
- Java as the core language
- Google Guice for dependency injection


