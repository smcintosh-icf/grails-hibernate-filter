package hibernate.filter.example

import org.grails.plugin.hibernate.filter.WithHibernateFilter

class Foo implements WithHibernateFilter {

    String name
    Boolean enabled

    static hasMany = [bars: Bar]

    static hibernateFilters = {
        fooEnabledFilter(condition: 'enabled=1', default: true, aliasDomain: 'EnabledFoo')
        barEnabledFilter(collection: 'bars', condition: 'enabled=1', default: true)
        fooNameFilter(condition: ':name = name', types: 'string')
        closureDefaultFilter(condition: 'enabled=1', default: { -> false })
        inListFilter(condition: '(organisation_id = :oragnisationId or organisation_id in (:organisationIds))',
                default: false,
                paramTypes: 'long, long')
        multipleUseParamFilter(condition: 'id > :avoid or id < :avoid', types: 'long', default: false)
    }

    String toString() {
        "Foo($id):$name:$enabled"
    }
}