package com.justinwells.joinslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private customViewAdapter adapter;
    private List<String>displayList;
    Helper helper = Helper.getInstance(MainActivity.this);


    View.OnClickListener getResults = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.button1:
                    displayList = helper.getMacyEmployees();
                    break;

                case R.id.button2:
                    displayList = helper.getBostonCompanies();
                    break;

                case R.id.button3:
                    displayList = helper.getHighestPaid();
                    break;
            }

            adapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Employee> employeeList = new ArrayList<>();
        List<Job> jobList = new ArrayList<>();
        displayList = new ArrayList<>();

        Button sameCompanyButton = (Button) findViewById(R.id.button1);
        Button companiesInBoston = (Button) findViewById(R.id.button2);
        Button highestSalary = (Button) findViewById(R.id.button3);

        employeeList.add(new Employee("123_04_5678", "John", "Smith", "NY",1973));
        employeeList.add(new Employee("123_04_5679", "David", "McWill", "Seattle",1982));
        employeeList.add(new Employee("123_04_5680", "Katerina", "Wise", "Boston",1973));
        employeeList.add(new Employee("123_04_5681", "Donald", "Lee", "London",1992));
        employeeList.add(new Employee("123_04_5682", "Gary", "Henwood","Las Vegas", 1987));
        employeeList.add(new Employee("123_04_5683", "Anthony", "Bright", "Seattle", 1963));
        employeeList.add(new Employee("123_04_5684", "William", "Newey", "Boston", 1995));
        employeeList.add(new Employee("123_04_5685", "Melony", "Smith", "Chicago", 1970));



        jobList.add(new Job("123_04_5678", 60, 1, "Fuzz"));
        jobList.add(new Job("123_04_5679", 70, 2, "GA"));
        jobList.add(new Job("123_04_5680", 120, 5, "Little Place"));
        jobList.add(new Job("123_04_5681", 78, 3, "Macys"));
        jobList.add(new Job("123_04_5682", 65, 1, "New Life"));
        jobList.add(new Job("123_04_5683", 158, 6, "Believe"));
        jobList.add(new Job("123_04_5684", 200, 8, "Macys"));
        jobList.add(new Job("123_04_5685", 299, 12, "Stop"));

        for (int i = 0; i < employeeList.size(); i++) {
            helper.insertRowEmployee(employeeList.get(i));
        }

        for (Job job : jobList) {
            helper.insertRowJobs(job);
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapter = new customViewAdapter(displayList);
        recyclerView.setAdapter(adapter);





        sameCompanyButton.setOnClickListener(getResults);
        companiesInBoston.setOnClickListener(getResults);
        highestSalary.setOnClickListener(getResults);
    }
}
