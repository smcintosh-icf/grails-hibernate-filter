package org.grails.plugin.hibernate.filter

import org.hibernate.Filter

/**
 * This trait allows the IDE some code sense. The actual method implementation are done dynamically by HibernateFilterUtils.groovy
 */
trait WithHibernateFilter {
    static abstract Object withHibernateFilter(String filterName, Closure closure)
    static abstract Object withHibernateFilters(Closure closure)
    static abstract Object withoutHibernateFilter(String filterName, Closure closure)
    static abstract Object withoutHibernateFilters(Closure closure)
    static abstract Filter enableHibernateFilter(String filterName)
    static abstract void disableHibernateFilter(String filterName)
}