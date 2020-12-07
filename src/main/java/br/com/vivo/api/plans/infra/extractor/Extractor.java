/*
 * @(#)Extractor.java 1.0 31/10/2020
 *
 * Copyright (c) 2020, PicPay S.A. All rights reserved.
 * PicPay S.A. proprietary/confidential. Use is subject to license terms.
 */

package br.com.vivo.api.plans.infra.extractor;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 06/10/2020
 */
@FunctionalInterface
public interface Extractor<T, D> {

    D extract(final T extract);

}
