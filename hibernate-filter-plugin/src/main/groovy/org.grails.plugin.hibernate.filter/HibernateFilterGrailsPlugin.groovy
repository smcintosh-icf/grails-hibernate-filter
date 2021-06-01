package org.grails.plugin.hibernate.filter

import grails.core.GrailsClass
import grails.plugins.*
import org.grails.core.artefact.DomainClassArtefactHandler

class HibernateFilterGrailsPlugin extends Plugin {

	// the version or versions of Grails the plugin is designed for
	def grailsVersion = "4.0.10 > *"
	def loadAfter = ['controllers', 'hibernate']
	def observe = ['*']
	def pluginExcludes = []

	def author = 'Scott Burch'
	def authorEmail = 'scott@bulldoginfo.com'
	def title = 'Hibernate Filter plugin'
	def description = 'Integrates Hibernate filtering into Grails 4'
	def documentation = 'http://grails.org/plugin/hibernate-filter'

	def license = 'APACHE'
	def developers = [
			[name: 'Burt Beckwith', email: 'beckwithb@vmware.com'],
			[name: 'Alex Shneyderman', email: 'a.shneyderman@gmail.com'],
			[name: 'Piotr Chowaniec', email: 'piotr.chowaniec@gmail.com'],
			[name: 'Alex Kramer', email: 'ackramer19@gmail.com'],
			[name: 'Yuri Lima', email: 'yuri.vdl@gmail.com']]
	def issueManagement = [system: 'GitHub', url: 'https://github.com/yvdlima/grails-hibernate-filter/issues']
	def scm = [url: 'https://github.com/yvdlima/grails-hibernate-filter']
	def profiles = ['plugin']

	void doWithDynamicMethods() {
		for( GrailsClass dc in grailsApplication.getArtefacts( DomainClassArtefactHandler.TYPE ) ) {
			HibernateFilterUtils.addDomainClassMethods dc.clazz, getApplicationContext()
		}

		for( Class artefactClass in grailsApplication.allArtefacts ) {
			HibernateFilterUtils.addDomainProxies artefactClass
		}
	}

    Closure doWithSpring() {{->
		def domains = []
		for( GrailsClass dc in grailsApplication.getArtefacts( DomainClassArtefactHandler.TYPE ) ) {
			domains.add(dc.clazz)
		}

		hibernateConnectionSourceFactory(HibernateFilterConnectionSourceFactory, domains  as Class[])

		hibernateFilterInterceptor(HibernateFilterInterceptor) {
			sessionFactory = sessionFactory
		}
    }}
}
