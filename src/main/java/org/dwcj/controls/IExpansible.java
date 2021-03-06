package org.dwcj.controls;


public interface IExpansible {

    /**
     * set the expanse attribute of the control
     *
     * @param expanse the expanse
     * @return the control itself
     */
    IExpansible setExpanse(Expanse expanse);

    enum Expanse {
        LARGE, MEDIUM, SMALL, XLARGE, XSMALL
    }

}
