package hibernate.filter.example

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.*

class UserControllerSpec extends Specification implements ControllerUnitTest<UserController>, DataTest {

    void setupSpec() {
        mockDomain User
    }

    def populateValidParams(params) {
        assert params != null
        params["firstName"] = 'John'
        params["lastName"] = 'Doe'
        params["active"] = true
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.userList
        model.userCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.user != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def user = new User()
        user.validate()
        controller.save(user)

        then: "The create view is rendered again with the correct model"
        model.user != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        user = new User(params)

        controller.save(user)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/user/show/1'
        controller.flash.message != null
        User.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def user = new User(params)
        controller.show(user)

        then: "A model is populated containing the domain instance"
        model.user == user
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def user = new User(params)
        controller.edit(user)

        then: "A model is populated containing the domain instance"
        model.user == user
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/user/index'
        flash.message != null

        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def user = new User()
        user.validate()
        controller.update(user)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.user == user

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        user = new User(params).save(flush: true)
        controller.update(user)

        then: "A redirect is issued to the show action"
        user != null
        response.redirectedUrl == "/user/show/$user.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/user/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def user = new User(params).save(flush: true)

        then: "It exists"
        User.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(user)

        then: "The instance is deleted"
        User.count() == 0
        response.redirectedUrl == '/user/index'
        flash.message != null
    }
}
