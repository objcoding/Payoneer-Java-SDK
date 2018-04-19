

- 基本用法

```java
Payoneer payoneer = PayoneerBuilder
				.newBuilder("programId", "authUsername", "authPassword")
  				.build();

// 收款
payoneer.charges().charge(ChargeRequest request);
```



- 相关博客

[payoneer pay 支付流程](http://objcoding.com/2018/04/09/payoneer-pay/)



