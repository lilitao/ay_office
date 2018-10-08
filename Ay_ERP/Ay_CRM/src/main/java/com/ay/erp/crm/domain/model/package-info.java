/**
 * 这个package包括了CRM系统核心domain的抽象，整个系统的业务都是基于这些核心domain抽象。
 * <ul>
 *     <li>
 *         Individual是entity对于一个自然人的抽象，封装了一个自然人在系统中的行为和属性。
 *     </li>
 *     <li>
 *         Phone是一个value object，是Individual其中的一个属性集合，包括了一个人的手机，家庭电话，办公电话等电话信息。
 *         在系统中，两个独立的phone之间，在没有Individual的上下文中,没有业务意义，只是作为一个Individual的值使用，所以phone抽象成
 *         value object
 *     </li>
 *     <li>
 *         Email是一个value object,是Individual其中的一个属性集合，包括了一个人的email信息。
 *         在系统中，两个独立的email之间，在没有Individual的上下文中，没有业务意义，只是作为一个Individual的值使用，所以email抽象成
 *         value object
 *     </li>
 *     <li>
 *         Address是一个value object,是Individual其中的一个属性集合，包括了一个人的Address信息，有可能是家庭住址，有可能是办公地址，或者
 *         这个人录入了两种类型的地址。在系统中，两个独立的address之间，在没有Individual的上下文中，没有业务意义，只是作为一个Individual的值使用，所以
 *         Address抽象成为一个value object
 *     </li>
 *     <li>
 *         Organization是对于一家客户公司或者集团公司的抽象，包括了一家客户的基本属性与业务行为。
 *         一个客户可能括多个子客户，客户内部的组织机构或者部门抽象成Group
 *     </li>
 *     <li>
 *         Group是对于Organization内部组织或者部门的抽象，一个Organization下面有一个或者多个Group,每个Group下属还可以设置0个或者多个Group。
 *         Organization和Group都是对客户公司和公司内部组织机构的抽象。
 *     </li>
 *     <li>
 *         Member是对于一个客户里面的成员的抽象，包括成员客户组织下的属性，比如薪水，入职日期，职工号，离职日期等。
 *         同时Member必然是一个Individual，同一个Individual与不同的Organization之间可能存在多个Member
 *     </li>
 *     <li>
 *         Dependent的家庭成员，有可能是妻子，小孩子，父母。一个Dependent必然是一个Individual
 *     </li>
 * </ul>
 *
 * <p>
 *     <img  src="core-domain.svg" alt="core-domain.svg">
 * </p>
 *
 * <p>
 *     基于这些核心domain的use case有主要有以下 这些：
 * </p>
 * <ul>
 *     <li>
 *         客户member信息批量上传:Member File Upload。技术细节请参考：{@link com.ay.erp.crm.domain.service.MemberFileUploadService}
 *     </li>
 *     <li>
 *         客户member信息在线维护管理:Manual Input。技术细节请参考:{@link com.ay.erp.crm.domain.service.ManualInputService}
 *     </li>
 * </ul>
 * <p>以下部分详细描述这些use case</p>
 * <p>
 *     Member File Upload
 * </p>
 * <p>
 *     用户登录系统后，打开Member File Upload功能页面，上传一个记录有Member的excel文件，excel文件的版本必须是2007以上版本，不支持2003版本。
 *     系统接收到excel文件后，系统执行以下步骤
 *
 * </p>
 * <ul>
 *     <li>
 *         用户预先在系统设置好的上传文件header规则，当系统接收到
 *     </li>
 * </ul>
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

class Member << E,Yellow>>
class Dependent <<E,yellow>>

Member : -individualId
Member : -organizationId

Dependent : -dependentType
Dependent : -memberId
Dependent : -individualId

Dependent "*" --|>  "1" Individual

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

Individual "1" <|-- "*" Member

 package "MemberFile" {
    class MemberFile <<R,orchid>>
    class MemberFileHeader <<E,Yellow>>
    class MemberFileItem <<E,Yellow>>
}

 MemberFile : -memberFileHeader
 MemberFile : +buildMemberFileItem()

 MemberFile "1" *-- "1" MemberFileHeader
 MemberFile "1" *-- "*" MemberFileItem
MemberFile "1" *-- "*" Member


 class ExceptionReport <<E,Yellow>>
 class ControlReport <<E,Yellow>>

 ExceptionReport "*" --* "1" MemberFile
 ControlReport "*" --* "1" MemberFile

@enduml
 -->
 */
package com.ay.erp.crm.domain.model;