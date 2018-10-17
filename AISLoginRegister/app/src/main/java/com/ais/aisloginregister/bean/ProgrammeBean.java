package com.ais.aisloginregister.bean;

/**
 * Copyright (C) 2018 CYu. All rights reserved.
 *
 * @Package: com.ais.aisloginregister.bean
 * @Description:
 * @author: Shaw
 * @date: 17/10
 */
public class ProgrammeBean {
    public String Name;
    public String Type;

    public ProgrammeBean(String pName, String pType) {
        Name = pName;
        Type = pType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String pName) {
        Name = pName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String pType) {
        Type = pType;
    }
}
