/**
 <!--
@startuml core-domain.svg
package "Individual" {
class Individual << R , orchid>>
class Phone << V , green >>
class Email << V,green>>
class AddressVO <<V,green>>

Individual : -name
Individual : -birthday
Individual : -sex

Phone : -phoneNumber
Phone : -type

Email : -emailAddress
Email : -type

AddressVO : -address
AddressVO : -type
}

package "Member" {
class Member << R,orchid>>
class Dependent <<E,yellow>>

Member : -individualId
Member : -organizationId
}

package "Organization" {
class Organization <<R,orchid>>
class Group <<E,Yellow>>

Organization : parentId
Group : parentId
}

Organization "1" *-- "*" Group
Organization "1" *-- "*" Organization
Group "1" *-- "*" Group


Member "1" *-- "*" Dependent
Member "*" --* Organization

Individual "1" *-- "*" Phone
Individual "1" *-- "*" Email
Individual "1" *-- "*" AddressVO

Individual "1" *-- "*" Member




@enduml
 -->
 */
package com.ay.erp.crm.domain.model;