# Geektrust Coding Challenge
1. The money allocated in equity, debt and gold funds.
2. Monthly SIP payments.
3. Monthly change rate (loss or growth) for each type of fund..

The output should be
1. Balanced amount of each fund for a certain month.
2. Rebalanced amount of each month if applicable.

Input Commands

There are 5 input commands defined to separate out the actions. Your input format will start with either of these commands i.e ALLOCATE, SIP, CHANGE, BALANCE, REBALANCE

ALLOCATE

The ALLOCATE command receives the initial investment amounts for each fund.

Format - ALLOCATE AMOUNT_EQUITY AMOUNT_DEBT AMOUNT_GOLD
Example- ALLOCATE 6000 3000 1000 means that an amount of 6000, 3000 and 1000 is initially invested in equity, debt and gold fund respectively.

SIP

The SIP command receives the investment amount on a monthly basis for each fund.

Format - SIP AMOUNT_EQUITY AMOUNT_DEBT AMOUNT_GOLD
Example - SIP 2000 1000 500 means a monthly payment of 2000, 1000 and 500 is done against each of equity, debt and gold funds respectivelty.

CHANGE

The CHANGE command receives the monthly rate of change (growth or loss) for each fund type. A negative value represents a loss.

Format - CHANGE AMOUNT_EQUITY AMOUNT_DEBT AMOUNT_GOLD MONTH
Example - CHANGE 8.00% -3.00% 7.00% APRIL means in the month of April equity received a growth of 8%, debt has taken a loss by 3% and gold received a growth of 7%.

BALANCE

The BALANCE command receives a month name.

Format - BALANCE MONTH
Example - BALANCE APRIL means - print the balance for each fund as on April month.

REBALANCE

The REBALANCE command receives no additional inputs.

Input format - REBALANCE
Example - REBALANCE - Rebalance happens compulsorily after 6 months in June and December. The REBALANCE command shows the last rebalanced amount for each fund at the time of rebalancing. If 6 months data is not available then print CANNOT_REBALANCE.

Output format - EQUITY DEBT GOLD
Example - 10593 7898 2273

Implementation:

MyMoneyFactory - Returns the instance type of implementation based on type of command being passed

MyMoneyService - A common interface for processing each type of command

Created an interface which will implementations based on type of input command being passed.
ALLOCATE - AllocateMoneyServiceImpl
SIP - BalanceServiceImpl
CHANGE - MonthlyChangeServiceImpl
BALANCE - BalanceServiceImpl
REBALANCE - RebalanceServiceImpl

Contants class is used for necessary constants

Model package has necessary models 
  - CurrentPortfolio -  for current portfolio information at any given time
  - InitialPortfolioAllocation - for initial amount invested, percentage of amount in each funds, SIP amount
  - Investment - for allocation in each fund and total
  - InvestmentPercentage - holds percentage of amount in each funds when initally invested
  - SIPAllocation - SIP allocation amount for each month
  
Util class is used for basic operations which are common across classes

