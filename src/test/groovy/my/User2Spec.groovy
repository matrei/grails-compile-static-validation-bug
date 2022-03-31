package my

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class User2Spec extends Specification implements DomainUnitTest<User2> {

    void '#field is validated correctly for value #value'() {

        given: 'a user with a value set for a field'
        def user2 = new User2()
        user2[field] = value

        when: 'validating that field'
        def validationResult = user2.validate([field])

        then: 'the validation result is as expected'
        errorCode == user2.errors[field]?.code
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
