package com.github.kamys.managerProduct;

import com.github.kamys.managerProduct.data.BaseFacade;
import com.github.kamys.managerProduct.logic.LogicFacade;

/**
 * Using this facade is main for to work with library ManagerProduct.
 */
public class ManagerProduct {
    private LogicFacade logicFacade;
    private BaseFacade baseFacade;

    public LogicFacade getLogicFacade() {
        return logicFacade;
    }

    public void setLogicFacade(LogicFacade logicFacade) {
        this.logicFacade = logicFacade;
    }

    public BaseFacade getBaseFacade() {
        return baseFacade;
    }

    public void setBaseFacade(BaseFacade baseFacade) {
        this.baseFacade = baseFacade;
    }
}
