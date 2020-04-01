package com.kaituo.comparison.back.core.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Objects;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2020/4/1 9:55
 * @Modified by:
 */

public class ReactorTest {

    @Test
    public void test() {
        Flux.just("xiaoyu").map(v -> v.contains("xiaoyu")).filter(Objects::nonNull).subscribe(System.out::println);
    }
}
