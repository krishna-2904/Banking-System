
# Java GUI Banking System

This project is a desktop-based banking application developed using Java and Swing. It allows users to log in and perform core banking operations such as deposits, withdrawals, balance checks, and fund transfers. The application also includes useful features like loan eligibility checks, EMI calculations, fixed deposit maturity, and a transaction history viewer.

## Key Functionalities

- User login authentication
- Deposit and withdraw funds
- View account balance
- Transfer funds to another user
- Check loan eligibility based on income
- EMI (Equated Monthly Installment) calculator
- Fixed Deposit maturity calculator
- Transaction History log with scrollable viewer

## Technologies Used

- Java SE (Standard Edition)
- Java Swing for building the GUI
- Java Collections (HashMap, ArrayList) to simulate user data and logs

## Folder Contents

- `Main.java` – Program entry point
- `Start.java` – Login interface
- `Dashboard.java` – User options menu with all banking features
- `Services.java` – Core logic for each service
- `Database.java` – Simulated backend storage and transaction logger
- `README.md` – Documentation and setup guide

## How to Use

1. Open the folder in any Java IDE (BlueJ, IntelliJ, Eclipse, etc.)
2. Compile all the `.java` files
3. Run `Main.java` to launch the application
4. Use the default credentials:

```
Username: user
Password: pass
```

These are defined in `Database.java`

## Notes

- No external database is used. All user data and transaction history are stored in-memory.
- Each transaction (deposit, withdraw, transfer) is automatically recorded.
- Transaction history is viewable via a scrollable text window.
- EMI and FD calculators are based on standard financial formulas.
- Error handling and input validation are implemented for all major features.

## Author

Krishna Gupta
