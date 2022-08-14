## _SalesTaxesProject_
SalesTaxesProject generates the receipt for purchased items, containing the list of products, their bills, sales taxes, and the total bill. It offers you the option to select products from a list of products and produces the receipt for it.

## How to run
You can clone or download the project in your local repository, and run it in any IDE (MAIN method is in SalesTaxes.java). Also, you can find the jar file `SalesTaxesProject.jar` in the location: [out/artifacts/SalesTaxesProject_jar](https://github.com/farhin105/SalesTaxesProject/tree/main/out/artifacts/SalesTaxesProject_jar)
You can download the jar file and run it from the command line.
To run the jar file, execute the following in your command prompt.
```sh
java -jar SalesTaxesProject.jar
```
All the logs will be saved in `logs` folder in the current directory from where the application is running.

## How to use
Upon running the project, it presents a list of product descriptions (which was provided in the problem statement file) and their corresponding numbers. It looks something like the below.
```sh
Input corresponding number to purchase the product:
1. [1 book at 12.49]
2. [1 music CD at 14.99]
3. [1 chocolate bar at 0.85]
4. [1 imported box of chocolates at 10.0]
5. [1 imported bottle of perfume at 47.5]
6. [1 imported bottle of perfume at 27.99]
7. [1 bottle of perfume at 18.99]
8. [1 packet of headache pills at 9.75]
9. [1 box of imported chocolates at 11.25]

Please input the mentioned product number, or type '0' (zero) to terminate
```
To select a product you have to input the corresponding number of that product. If you are done and want to generate the receipt, you have to enter `0` (zero). If you enter `0`, then it will generate the receipt.
```sh
Please input the mentioned product number, or type '0' (zero) to terminate
0
-------------- Receipt ----------------
1 imported box of chocolates : 10.5
1 imported bottle of perfume : 54.65
Sales Taxes : 7.65
Total Bill : 65.15
```
It will also ask you if you want to continue shopping.
```sh
continue shopping? [press 'y' continue / any key to terminate]
```
You can enter `y` to continue, or enter any other key to terminate the program.
The program will also instruct you through the process.

## Tech stack
- Maven for dependency management
- Java as the core language
- Google Guice for dependency injection
