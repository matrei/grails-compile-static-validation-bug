package my

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class User1Spec extends Specification implements DomainUnitTest<User1> {

    void '#field is validated correctly for value #value'() {

        given: 'a user with a value set for a field'
        def user1 = new User1()
        user1[field] = value

        when: 'validating that field'
        def validationResult = user1.validate([field])

        then: 'the validation result is as expected'
        errorCode == user1.errors[field]?.code
        valid == validationResult

        where:
        field | value || valid | errorCode
        'name' | null || false | 'nullable'
        'name' | ''   || false | 'blank'
        'name' | 'a' * 4 || false | 'minSize.notmet'
        'name' | 'a' * 5 || true | null
        'name' | 'a' * 10 || true | null
        'name' | 'a' * 11 || false | 'maxSize.exceeded'

    }
}
