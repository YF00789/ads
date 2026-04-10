# Mini Banking System - Data Structures Implementation

## Summary
This is a simple console-based application that simulates a mini banking system.
The system is a modular CLI divided into three roles:
1. **Bank Interface:** For deposits, withdrawals, submitting requests, paying bills.
2. **ATM Interface:** For balance inquiries and withdrawals.
3. **Admin Area:** For employees to manage active accounts and process pending queues.

### Task 1:
1. **Data Structure:** `LinkedList<BankAccount>`
2. **Explanation:** Defined an account class. Accounts are managed as a LinkedList to have no strict size limitations and to allow an easy search for a specific account using `findAccount()` method.


### Task 2:
**Explanation:** Inside the Bank and ATM menus, users can control their balances. The code searches the `LinkedList` for the username. If found, it updates the balance. For withdrawals, it includes basic validation to make sure that the account has sufficient funds before deducting the amount.


### Task 3:
1. **Data Structure:** `Stack<String>`
2. **Explanation:** The system tracks user actions - Deposits, Withdrawals, and Bill Payments using a `transactionHistory` stack.
    * When a transaction occurs, its `push()`ed to the stack.
    * Users can view the most recent transaction using `peek()`.
    * Users can undo the last transaction log using `pop()`.


### Task 4:
1. **Data Structure:** `Queue<String>`
2. **Explanation:** Bill payments are handled via Queue `billQueue`. Users submit bill requests through the Bank Menu, and the Bank Admin reviews and processes them one by one in the order they were received.

### Task 5:
1. **Data Structure:** `Queue<BankAccount>`
2. **Explanation:** Users submit an account creation application via the Bank Menu, which packages their details into a `BankAccount` object and adds it to `accountRequests` Queue. The Admin goes into the Admin Menu to review and approve these requests. After approval, the account is moved from the Queue into the main `accounts` LinkedList.

### Task 6:
* **Data Structure:** Array `BankAccount[]`
* **Explanation:** It runs at the start of the program and shows the use of a fixed-size data structure. An array of size 3 is created and filled with predefined accounts `Ali, Sara, Zaid`. Then the program iterates through the array and transfers the accounts into the main `LinkedList`.

### Banking Menu
* **Explanation:** The interactive part of the application. It uses a `while(true)` loop and `Scanner` inputs to navigate between different parts of the system:
    * **Bank Menu:** Queue submissions - bills/accounts and full transaction management.
    * **ATM Menu:** Withdrawals and balance checks.
    * **Admin Menu:** Allows staff to view all records, search for specific users, and process the pending `accountRequests` and `billQueue`.

**IMPORTANT NOTE: No screenshots because parts of the same tasks are all over the code and there are too many results, so it's way more efficient to show and explain them in-person**