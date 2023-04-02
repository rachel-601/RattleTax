package model;

import java.util.HashMap;

public class T4Info {
    private HashMap<Integer, String> t4Info = new HashMap<>();

    public T4Info() {
        t4Info.put(54, "Employer's account number");
        t4Info.put(12, "Your SIN number");
        t4Info.put(14, "Employment income" + "\nThe total amount of money that an individual earns from their job, " +
                "including salary, wages, tips, bonuses, and other forms of compensation.");
        t4Info.put(22, "Income tax deducted" + "\nThe money taken out of your salary or income before you receive it, " +
                "to pay for the taxes you owe to the government.");
        t4Info.put(16, "Employee's CPP (Canada Pension Plan) contributions" + "\nThe amounts of money that an " +
                "individual pays from their employment income to contribute towards their future retirement benefits " +
                "under the CPP program.");
        t4Info.put(24, "EI (Employment Insurance) insurable earnings" + "\nRefers to the portion of an individual's " +
                "employment income on which they are required to pay EI premiums and may receive benefits in case " +
                "of job loss.");
        t4Info.put(17, "Employee's QPP (Quebec Pension Plan) contributions" + "\nThe amounts of money that an " +
                "individual pays from their employment income to contribute towards their future retirement " +
                "benefits under the QPP program in Quebec, Canada.");
        t4Info.put(26, "CPP/QPP pensionable earnings" + "\nRefers to the portion of an individual's employment income on " +
                "which they are required to pay CPP/QPP contributions and which is used to calculate their future " +
                "retirement benefits under the CPP/QPP program.");
        t4Info.put(18, "Employee's EI (Employment Insurance) premiums" + "\nThe amounts of money that an individual " +
                "pays from their employment income to contribute towards the EI program, which provides temporary " +
                "financial assistance to workers who have lost their job.");
        t4Info.put(44, "Union dues" + "\nThe regular payments made by an employee to a labor union as a condition of " +
                "their employment, which are tax-deductible and used to support the activities and programs of the " +
                "union.");
        t4Info.put(20, "RPP (Registered Pension Plan) contributions" + "\nThe amounts of money that an individual " +
                "pays towards a pension plan registered with the government, which provides retirement income to " +
                "the individual after they retire.");
        t4Info.put(46, "Charitable donations" + "\nThe amounts of money or property donated by an individual to a " +
                "registered charity or other qualified donee, which can be claimed as a tax credit or deduction on " +
                "their tax return.");
        t4Info.put(52, "Pension adjustment" + "\nA calculation used to determine the amount of contributions an " +
                "individual made to their registered pension plan in a given year and to limit the tax deduction " +
                "available for additional contributions.");
        t4Info.put(50, "RPP (Registered Pension Plan) or DPSP (Deferred Profit-Sharing Plan) registration number " +
                "\nA unique identification number assigned by the Canada Revenue Agency to a registered pension " +
                "plan or a deferred profit-sharing plan to ensure compliance with tax regulations.");
        t4Info.put(55, "Employee's PPIP (Public Pension Investment Plan) premiums" + "\nThe amounts of money that an " +
                "individual pays from their employment income to contribute towards the PPIP program, which provides " +
                "retirement, survivor, and disability benefits to public service employees in some Canadian provinces.");
        t4Info.put(56, "PPIP (Public Pension Investment Plan) insurable earnings" + "\nRefers to the portion of an " +
                "individual's employment income on which they are required to pay PPIP premiums and which is used to " +
                "calculate their future retirement, survivor, and disability benefits under the PPIP program in some " +
                "Canadian provinces.");
    }
}
