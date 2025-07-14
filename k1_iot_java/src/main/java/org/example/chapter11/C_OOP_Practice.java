package org.example.chapter11;

/*
 * === SOLID 원칙
 * SRP 단일 책임원칙 - 하나의 클래스는 하나의 책임
 * OCP 개방 폐쇄원칙 - 확장에 오픈 수정에 클로스
 * LSP 리스코프 치환 원칙 - 자식 클래스는 부모 클래스를 대체할수 있어야 한다.(부모클래스의 행위를 자식 클래스가 제어할 수 없다.)
 * ISP 인터페이스 분리 원칙 - 자신이 사용하지 않는 인터페이스에 의존하지 않아야 한다.
 * DIP 의존 역전 원칙 - 클래스간의 결합은 낮추고, 추상화에 의존해야함
 */
//==SOLID 원칙을 적용한 주문관리 시스템(LSP는 기본적으로 깔고감)===

// 1. SRP - Order 클래스는 주문 정보를 저장하는 역할만 담당
class Order {
    private String orderId;
    private int amount;

    public Order(String orderId, int amount) {
        this.amount = amount;
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getAmount() {
        return amount;
    }
}

// 2. OCP - 결제 프로세스를 추상화한 인터페이스 생성
interface PaymentProcessor {
    void processerPayment(Order order);
}

class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public void processerPayment(Order order) {
        System.out.println("신용카드로 결게합니다: " + order.getOrderId());
    }
}

class SamsungPayPaymentProcessor implements PaymentProcessor {
    @Override
    public void processerPayment(Order order) {
        System.out.println("삼성페이로 결제합니다.: "+ order.getOrderId());
    }
}
// 3. ISP - 주문 보고서 생성을 위한 별도의 인터페이스
interface GenerateReport{
    void generateReport(Order order);
}
class PdfReportGenerate implements GenerateReport{
    @Override
    public void generateReport(Order order) {
        System.out.println("주문 정보 보고서를 pdf 파일로 생성: "+ order.getOrderId());
    }
}
// DIP - orderService 클래스는 결제 및 보고서 생성 인터페이스에 의존
class OrderService{
    private final PaymentProcessor paymentProcessor;
    private final GenerateReport generateReport;
    //생성자에게 결게 처리기 & 보고서생성기 주입(인터페이스와 의존을 주입)
    public OrderService(PaymentProcessor paymentProcessor, GenerateReport generateReport){
        this.paymentProcessor = paymentProcessor;
        this.generateReport = generateReport;
    }
    void placeOrder(Order order){
        paymentProcessor.processerPayment(order);
        generateReport.generateReport(order);
        System.out.println("주문완료");
    }
}
public class C_OOP_Practice {
    public static void main(String[] args) {
        PaymentProcessor creditCardPaymentProcessor = new CreditCardPaymentProcessor();
        PaymentProcessor samsunPayPaymentProcessor = new SamsungPayPaymentProcessor();

        GenerateReport generateReport = new PdfReportGenerate();

        OrderService orderService1 = new OrderService(creditCardPaymentProcessor, generateReport);
        OrderService orderService2 = new OrderService(samsunPayPaymentProcessor, generateReport);

        //여러개의 주문 객체 생성
        Order order1 = new Order("1", 18000);
        Order order2 = new Order("2", 28000);
        Order order3 = new Order("3", 13000);
        Order order4 = new Order("4", 34000);

        orderService1.placeOrder(order1);
        orderService1.placeOrder(order2);
        orderService2.placeOrder(order3);
        orderService2.placeOrder(order4);
    }
}
