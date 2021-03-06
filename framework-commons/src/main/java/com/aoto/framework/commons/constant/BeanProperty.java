/*
 * 版权信息：Copyright (c) 2014, Aoto. All rights reserved.
 * 文件编号：BeanProperty.java
 * 文件名称：BeanProperty.java
 * 系统编号：aotoframework
 * 系统名称：aotoframework
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2014年5月20日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.commons.constant;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author jiangp
 * @see    [相关类/方法]（可选）
 * @since  [产品/模块版本] （必须）
 */
public class BeanProperty
{
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class Bean
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String DELETED = "deleted";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String CREATED_BY = "createdBy";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String CREATED_DATE = "createdDate";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LAST_UPDATED_BY = "lastUpdatedBy";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LAST_UPDATED_DATE = "lastUpdatedDate";

        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PAGING = "paging";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LIST = "list";

        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String BEGIN_DATE = "beginDate";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String END_DATE = "endDate";
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class User
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String USER_ID = "userId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PRIMARY_KEY = "pk_" + USER_ID;
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String USERNAME = "username";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String REAL_NAME = "realName";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PWD = "pwd";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ORG_ID = "orgId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LOCKED = "locked";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ERROR_TIME = "errorTime";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PHONE = "phone";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String MOBILE = "mobile";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String EMAIL = "email";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ADDRESS = "address";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String REMARK = "remark";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LAST_LOGIN_DATE = "lastLoginDate";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LAST_LOGIN_IP = "lastLoginIp";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String USER_PIC_SUFFIX = "userPicSuffix";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String USER_PIC_DATA = "userPicData";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String AGE = "age";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String BIRTHDAY = "birthday";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ABOUT = "about";
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class Org
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String CONTAIN_SUB = "containSub";

        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ORG_ID = "orgId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PRIMARY_KEY = "pk_" + ORG_ID;
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ORG_NAME = "orgName";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PARENT_INHERITED_ID = "parentInheritedId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String INHERITED_ID = "inheritedId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String INHERITED_NAME = "inheritedName";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PARENT_ID = "parentId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String SORT_NUM = "sortNum";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LEVEL_NUM = "levelNum";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ORG_CODE = "orgCode";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ADDRESS = "address";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String REMARK = "remark";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PARENT_CODE = "parentCode";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String TEL = "tel";
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class Role
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ROLE_ID = "roleId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ROLE_TYPE = "roleType";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PRIMARY_KEY = "pk_" + ROLE_ID;
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ROLE_NAME = "roleName";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String REMARK = "remark";
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class Function
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String FUN_ID = "funId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PRIMARY_KEY = "pk_" + FUN_ID;
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String FUN_NAME = "funName";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PARENT_ID = "parentId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String SORT_NUM = "sortNum";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LEVEL_NUM = "levelNum";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ENABLED = "enabled";
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class Menu
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String MENU_ID = "menuId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PRIMARY_KEY = "pk_" + MENU_ID;
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String MENU_NAME = "menuName";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String MENU_URL = "menuUrl";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ICON = "icon";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PARENT_ID = "parentId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String FUN_ID = "funId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String SORT_NUM = "sortNum";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LEVEL_NUM = "levelNum";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String DELETED = "deleted";
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class Cache
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ORG_CACHE = "orgCache";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String DIC_CACHE = "dicCache";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String MENU_CACHE = "menuCache";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PERMISSION_CACHE = "permissionCache";
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class LoginLog
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String SESSION_ID = "sessionId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String IP = "ip";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LOGIN_DATE = "loginDate";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LOGOUT_DATE = "logoutDate";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String OS = "os";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String BROWSER = "browser";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String USER_AGENT = "userAgent";
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class BehaviorLog
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String BEHAVIOR_ID = "behaviorId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LOGGED_DATE = "loggedDate";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ACTION = "action";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String DATA_CHANGED = "dataChanged";
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class Url
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String URL_ID = "urlId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PRIMARY_KEY = "pk_" + URL_ID;
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String URL_NAME = "urlName";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String URL_PATTERN = "urlPattern";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String HTTP_METHOD = "httpMethod";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ACTION_CODE = "actionCode";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String ARGS_CODE = "argsCode";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LOGGED_DATA_CHANGED = "loggedDataChanged";
    }
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    public static final class Dic{
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String DIC_ID = "dicId";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String PRIMARY_KEY = "pk_" + DIC_ID;
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String DIC_TYPE = "dicType";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String DIC_NAME = "dicName";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String DIC_KEY = "dicKey";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String DIC_VALUE = "dicValue";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String DIC_SYMBOL = "dicSymbol";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String CREATED_BY = "createdBy";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String CREATED_DATE = "createdDate";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LAST_UPDATED_BY = "lastUpdatedBy";
        /**
         * [简要描述]:
         * @author zongwj
         */
        public static final String LAST_UPDATED_DATE = "lastUpdatedDate";
    }



    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author
     * @version 1.0,
     */
    public static final class RoomInfo{
        /**
         *
         */
        public static final String CONTAIN_SUB = "containSub";
        /**
         * 房源id
         */
        public static final String ROOM_ID = "roomID";
        /**
         *
         */
        public static final String PRIMARY_KEY = "pk_" + ROOM_ID;

        /**
         *
         */
        public static final String ROOM_NAME = "roomName";
        /**
         *
         */
        public static final String COMMUNITY = "community";
        /**
         *
         */
        public static final String RENT = "rent";
        /**
         *
         */
        public static final String HOUSE_TYPE = "houseType";
        /**
         *
         */
        public static final String ORIENTED = "oriented";
        /**
         *
         */
        public static final String RENT_TYPE = "rentType";
        /**
         *
         */
        public static final String ROOM_SIZE = "roomSize";
        /**
         *
         */
        public static final String ADDRESS = "address";
        /**
         *
         */
        public static final String INDOOR_STRUCTURE = "indoorStructure";
        /**
         *
         */
        public static final String COLOUR = "colour";
        /**
         *
         */
        public static final String DETAILED_INTRODUCTION = "detailedIntroduction";
        /**
         *
         */
        public static final String PAYMENT_METHOD = "paymentMethod";
        /**
         *
         */
        public static final String BUILDING_TYPE = "buildingType";
        /**
         *
         */
        public static final String ADMINISTRATIVE_AREA = "administrativeArea";
        /**
         *
         */
        public static final String INDOOR_FACILITIES = "indoorFacilities";
        /**
         *
         */
        public static final String OUTDOOR_FACILITIES = "outdoorFacilities";
        /**
         *
         */
        public static final String HOUSE_ADVANTAGE = "houseAdvantage";
        /**
         *
         */
        public static final String IMAGES = "images";
        /**
         *
         */
        public static final String QRCODE = "qrcode";
        /**
         *
         */
        public static final String VISIT_TIME = "visitTime";
        /**
         *
         */
        public static final String FLOOR = "floor";
        /**
         *
         */
        public static final String PUBLISHING_METHOD = "publishingMethod";
        /**
         *
         */
        public static final String WINDOW_NUM = "windowNum";
        /**
         *
         */
        public static final String PARK_SPACE = "parkSpace";
        /**
         *
         */
        public static final String BUILD_YEAR = "buildYear";
        /**
         *
         */
        public static final String DECORATION = "decoration";
        /**
         *
         */
        public static final String PUBLIC_DATE = "publicDate";
        /**
         *
         */
        public static final String UPDATE_DATE = "updateDate";
        /**
         *
         */
        public static final String HOUSE_ID = "houseID";
        /**
         *
         */
        public static final String COMMUNITY_LONGITUDE = "communityLongitude";
        /**
         *
         */
        public static final String COMMUNITYDIMENSION = "communityDimension";
        /**
         *
         */
        public static final String ROOM_LONGITUDE = "roomLongitude";
        /**
         *
         */
        public static final String ROOM_DIMENSION = "roomDimension";

        public static final String ROOM_TYPE = "roomType";

        public static final String Room_Status = "roomStatus";

        public static final String Room_Check = "roomCheck";

        public  static final String Room_Cause ="roomCause";


    }
}
