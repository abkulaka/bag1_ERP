# Цалин бодох ERP системийн модуль

## Төслийн танилцуулга

Энэхүү ERP системийн **цалин бодох систем** нь байгууллагын ажилтнуудын цалинг тооцоолох, нэмэгдэл/суутгал, ирцийн мэдээлэлтэй уялдуулан удирдах зорилготой Java (Maven) суурьтай систем юм. Энэ систем нь объект хандалтат загварыг ашиглан модульчлал сайтай бүтэцтэй, өргөтгөх боломжтой 
> **Гол томьёо**:  
> `Цэвэр цалин = Үндсэн цалин + Илүү цаг + Бонус - Тасалт - Татвар - Шимтгэл`

---

## Багийн гишүүд

| Овог Нэр         | Код           |
|------------------|---------------|
| Мягмарсүрэн       | B210910808    |
| Эрдэнэтунгалаг    | B232270157    |
| Билгүүн           | B210910829    |

---


## ⚙Модулийн үндсэн боломжууд

- Ажилтны мэдээлэл бүртгэх, устгах
- Цалингийн нарийвчилсан тооцоолол
- Илүү цаг, тасалт, торгууль, шимтгэл тооцох
- Цалингийн тайлан, мэдээлэл боловсруулах
- Хэрэглэхэд ойлгомжтой, хурдан, найдвартай

---

## Ашигласан технологиуд

- **Java 17**
- `java.io`, `Scanner` – файл унших/бичих
- OOP зарчим – `Encapsulation`, `Inheritance`, `Polymorphism`, `Abstraction`
- **UML диаграм** – Класс төлөвлөлт
- **Maven
- **JUnit 5 – Юнит тест
- **Log4j 2 – Лог менежмент



---
## Шинжилгээний товч тайлбар


## Классуудын бүтэц

| Ангийн нэр (`Class`) | Зорилго                                           | Үндсэн өгөгдөл / Үйлдэл                                                                 |
| -------------------- | ------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `Employee`           | Ажилчдын мэдээллийг хадгална                      | `id`, `name`, `salary`, `contract`                                                      |
| `Contract`           | Ажилтны гэрээний дэлгэрэнгүй тайлбарыг хадгална   | `details`                                                                               |
| `Attendance`         | Ирцийн мэдээлэл бүртгэнэ, ажилчдыг ирцэд бүртгэнэ | `daysPresent`, `presentEmployees`, `markPresent()`, `isPresent()`                       |
| `Bonus`              | Ажилтны бонус (нэмэгдэл) мэдээлэл                 | `amount`                                                                                |
| `Deduction`          | Ажилтны суутгалын мэдээлэл                        | `amount`                                                                                |
| `Salary`             | Тооцоологдсон цалингийн үр дүн                    | `employee`, `netSalary`                                                                 |
| `PayrollSystem`      | Цалинг тооцоолох гол модулиудыг удирдана          | `generateSalary()`, `getSalaries()`, бонус, суутгал, ирц зэргийг харгалзан цалин тооцно |
| `PayrollSystemTest`  | JUnit тест хариуцна                               | `testCalculateSalaryAndAttendance()` - Үр дүнг шалгах тест                              |
| `log4j2.xml`         | Лог бичих тохиргоо                                | Console болон файл руу бичих лог формат тодорхойлсон                                    |
| `pom.xml`            | Төслийн хамаарлууд болон билд тохиргоог удирдана  | Java 17, Maven, JUnit 5, Log4j 2                                                        |


---

## Цалин бодох логик

1. **Үндсэн цалин**
2. **Илүү цаг** – 1.5x нэмэгдэлтэй бодогдоно
3. **Бонус**
4. **Тасалт, хоцролт** – торгууль хасагдана
5. **Нийгмийн даатгал** – 10%
6. **Эрүүл мэндийн даатгал** – 5%
7. **Компанийн шимтгэл** – хувьсах нөхцлөөр

---

**Цалин бодолтонд багтсан зүйлс:**  
- Нийгмийн даатгал (10%)  
- Эрүүл мэндийн даатгал (5%)  
- Хоцорсон цагийн торгууль  
- Тасалсан өдрийн торгууль  
- Илүү цагийн нэмэгдэл (1.5x)  
- Компанийн шимтгэл болон торгууль

  ---

  ## Алдаа зохицуулалт ба шалгалт

- Employee:
  Нэр null, хоосон эсвэл зөвхөн whitespace байж болохгүй
  Цалин сөрөг байж болохгүй
-Bonus:
 Бонусын хэмжээ 0-аас багагүй, 5000-аас ихгүй байх шаардлагатай

- Deduction:
  Суутгал сөрөг байж болохгүй
  
- JUnit Edge Case Tests:
* Хоосон/буруу нэртэй ажилтан → IllegalArgumentException
* Сөрөг цалин → IllegalArgumentException
* 0-аас бага эсвэл 5000-аас их бонус → IllegalArgumentException
* null бонус эсвэл суутгал → Шалгагдана, 0 гэж тооцогдоно

---


**Төслийн давуу тал:**
- ООП зарчмыг дагасан (Encapsulation, Inheritance, Polymorphism, Abstraction)
- Хялбар өргөтгөл хийх боломжтой
- Unit Test болон лог хөтлөлттэй
- Хөнгөн, зохион байгуулалт сайтай бүтэц
- Хялбар өргөтгөл хийх боломжтой
- Unit Test болон лог хөтлөлттэй
- Хөнгөн, зохион байгуулалт сайтай бүтэц



# UML diagram
![UML](https://github.com/user-attachments/assets/9d9f97ec-4abb-4156-ab1f-81bf6b7683eb)

