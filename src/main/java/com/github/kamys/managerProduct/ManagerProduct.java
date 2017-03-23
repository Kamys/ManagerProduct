package com.github.kamys.managerProduct;

import com.github.kamys.managerProduct.logic.LogicFacade;

/**
 * Using this facade is main for to work with library ManagerProduct.
 */
class ManagerProduct {
    private LogicFacade logicFacade;

    public LogicFacade getLogicFacade() {
        return logicFacade;
    }

    public void setLogicFacade(LogicFacade logicFacade) {
        this.logicFacade = logicFacade;
    }
}
