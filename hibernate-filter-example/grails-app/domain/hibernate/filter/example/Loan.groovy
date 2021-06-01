package hibernate.filter.example

import org.grails.plugin.hibernate.filter.WithHibernateFilter

class Loan implements WithHibernateFilter {

    Integer amount
    Integer status = 1

    static belongsTo = [borrower: Student]

    static hibernateFilters = {
        collegeFilter(condition: 'status = 1')
    }
}
