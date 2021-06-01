package hibernate.filter.example

import org.grails.plugin.hibernate.filter.WithHibernateFilter

class User implements WithHibernateFilter {

    static constraints = {
    }

    String firstName
    String lastName
    boolean active = true

    static hibernateFilters = {
        activeFilter(condition: 'active=1', default: true)
    }
}
