# Цалин бодох ERP системийн модуль

## Төслийн танилцуулга

Энэхүү ERP системийн **цалин бодох модуль** нь байгууллагын ажилтнуудын цалинг хурдан, алдаагүй, найдвартай тооцоолох зорилготой. Систем нь хүний нөөцийн бүртгэл болон санхүүгийн тайланг автоматжуулахад чиглэсэн.

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
- **Текст файл хадгалалт** – UTF-8 кодчилол ашигласан

---

## Классуудын бүтэц

| Класс нэр          | Үүрэг                                               | OOP зарчим                |
|--------------------|------------------------------------------------------|---------------------------|
| `Employer`         | Ажилтны мэдээлэл нэмэх, устгах                      | Encapsulation             |
| `SalaryFromFile`   | Ажилтны файл дээр үндэслэн цалин бодох              | Abstraction               |
| `Attendance`       | Ирц, хоцролт, тасалт бүртгэх                        | Encapsulation             |
| `Insurance`        | Нийгмийн болон эрүүл мэндийн даатгалын хувь        | Abstraction               |
| `SalaryCalculator` | Цалинг бодох алгоритмыг хэрэгжүүлэх                | Polymorphism, Abstraction |
| `Person`           | Ажилтны ерөнхий мэдээлэл хадгалах (Superclass)     | Inheritance               |

---

## Цалин бодох логик

1. **Үндсэн цалин**
2. **Илүү цаг** – 1.5x нэмэгдэлтэй бодогдоно
3. **Бонус**
4. **Тасалт, хоцролт** – торгууль хасагдана
5. **Нийгмийн даатгал** – 10%
6. **Эрүүл мэндийн даатгал** – 5%
7. **Компанийн шимтгэл** – хувьсах нөхцлөөр

> Бүх мэдээлэл текст файлд хадгалагдаж, ажилтны ID-аар нэрлэгдсэн (`emp_itX.txt` гэх мэт).

---
## Шинжилгээний товч тайлбар

### 1. Employer.java  
Энэхүү класс нь хэрэглэгчийн мэдээллийг нэмэх болон хасах үйлдлүүдийг гүйцэтгэнэ. Мөн хэрэглэгчийн мэдээллийг гараас авч, дахин давтагдашгүй ID дугаарт хадгалдаг.

**Үндсэн функцууд:**  
- `addEmployee(Scanner scanner)`: Ажилтны мэдээллийг гарнаас авч, текст файлд UTF-8 кодчилол ашиглан хадгалдаг.  
- `deleteEmployee(Scanner scanner)`: Ажилтны дугаарыг оруулан тухайн нэртэй файлыг устгана.

### 2. Salary.java  
**Үүрэг:**  
- EmployeeManager-ээр хадгалсан файлуудын мэдээллийг уншиж, тухайн ажилтны цалинг тооцоолно.  
- Цалин бодохдоо ажилласан өдөр, тасалсан өдөр, илүү цаг, хоцорсон цаг, торгууль, шимтгэл зэрэг үзүүлэлтүүдийг авна.

**Үндсэн функцууд:**  
- `calculateNetSalary(...)`: Цалингийн нарийн тооцоолол хийдэг функц.  
- Хэрэглэгчээс мэдээлэл авч тухайн ажилтны мэдээлэлтэй уялдуулан цалин бодно.

**Цалин бодолтонд багтсан зүйлс:**  
- Нийгмийн даатгал (10%)  
- Эрүүл мэндийн даатгал (5%)  
- Хоцорсон цагийн торгууль  
- Тасалсан өдрийн торгууль  
- Илүү цагийн нэмэгдэл (1.5x)  
- Компанийн шимтгэл болон торгууль


# UML diagram
![UML diagram](https://github.com/user-attachments/assets/dd667935-f7f2-4d32-82e5-3d3302b908ff)
