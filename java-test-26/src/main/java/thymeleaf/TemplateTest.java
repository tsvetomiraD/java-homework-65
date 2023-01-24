package thymeleaf;

import java.io.File;
import java.io.PrintWriter;

public class TemplateTest {
    public static void main(String[] args) throws Exception {
        TemplateContext ctx = new TemplateContext();
        WelcomeMessage welcome = new WelcomeMessage("hello world");

        ctx.put("welcome", welcome);

        Student students[] = {
                new Student(1, "Ivan", 'm'),
                new Student(2, "Maria", 'f'),
                new Student(3, "Nikola", 'm')
        };

        ctx.put("students", students);

        Student student = new Student(4, "Iva", 'f');
        ctx.put("student", student);

        Template t = new Template("template.tm");
        File res = new File("output.html");
        PrintWriter out = new PrintWriter(res);
        t.render(ctx, out);
    }
}
