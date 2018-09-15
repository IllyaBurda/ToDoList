package entity;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;


public class Event {

    private final StringProperty description = new SimpleStringProperty(this, "description", null);
    private final IntegerProperty time = new SimpleIntegerProperty(this, "time", 0);
    private final ObjectProperty<TypeAction> name1 = new SimpleObjectProperty(this, "name", null);
    private final ObjectProperty<LocalDateTime> startAction = new SimpleObjectProperty(this, "startAction", null);
    private final ObjectProperty<PriorityAction> status = new SimpleObjectProperty(this, "status", null);



    Notification notification = new Notification(1, "Пора спасать человечество", 10);
    public static ObservableList<Event> list = FXCollections.observableArrayList();

    static {
        new Event(TypeAction.Free_Time, "Отдых", 200, PriorityAction.Very_Important, LocalDateTime.of(18, 9, 5, 11, 01));
        new Event(TypeAction.Shopping, "Купить кросовки", 100, PriorityAction.Unimportant, LocalDateTime.of(18, 9, 5, 15, 20));
        new Event(TypeAction.Errands, "Сходить за сметаной", 15, PriorityAction.Important, LocalDateTime.of(18, 9, 5, 15, 20));
    }

    public Event(TypeAction name, /*LocalDateTime beginPlan,*/ String description, int time, PriorityAction status,
                 LocalDateTime startAction) {
        this.name1.set(name);
//        this.beginPlan = beginPlan;
        this.description.set(description);
        this.time.set(time);
        this.status.set(status);
        this.startAction.set(startAction);
        list.add(this);
    }

    public int getTime() {
        return time.get();
    }

    public TypeAction getName1() {
        return name1.get();
    }

    public ObjectProperty<TypeAction> name1Property() {
        return name1;
    }

    public LocalDateTime getStartAction() {
        return startAction.get();
    }

    public ObjectProperty<LocalDateTime> startActionProperty() {
        return startAction;
    }

    public PriorityAction getStatus() {
        return status.get();
    }

    public ObjectProperty<PriorityAction> statusProperty() {
        return status;
    }

    public Notification getNotification() {
        return notification;
    }

    public final String getDescription() {
        return description.get();
    }

    public final StringProperty descriptionProperty() {
        return description;
    }

    public final IntegerProperty timeProperty() {
        return time;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }


    public void setName1(TypeAction name) {
        this.name1.set(name);
    }

    public void setTime(int time) {
        this.time.set(time);
    }

    public void setStatus(PriorityAction status) {
        this.status.set(status);
    }

    public void setStartAction(LocalDateTime startAction) {
        this.startAction.set(startAction);
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public static void setList(ObservableList<Event> list) {
        Event.list = list;
    }

//    @Override
//    public String toString() {
//        return
//                "name = " + name1;
//    }

    @Override
    public String toString() {
        return this.name1.get().toString() ;

    }
}

//public class Person {
//    // An enum for age categories
//    public enum AgeCategory {
//        BABY, CHILD, TEEN, ADULT, SENIOR, UNKNOWN
//    };
//
//    private final ReadOnlyIntegerWrapper personId =
//            new ReadOnlyIntegerWrapper(this, "personId", personSequence.incrementAndGet());
//    private final StringProperty firstName =
//            new SimpleStringProperty(this, "firstName", null);
//    private final StringProperty lastName =
//            new SimpleStringProperty(this, "lastName", null);
//    private final ObjectProperty<LocalDate> birthDate =
//            new SimpleObjectProperty<>(this, "birthDate", null);
//
//    // Keeps track of last generated person id
//    private static AtomicInteger personSequence = new AtomicInteger(0);
//
//    public Person() {
//        this(null, null, null);
//    }
//
//    public Person(String firstName, String lastName, LocalDate birthDate) {
//        this.firstName.set(firstName);
//        this.lastName.set(lastName);
//        this.birthDate.set(birthDate);
//    }
//
//    /* personId Property */
//    public final int getPersonId() {
//        return personId.get();
//    }
//
//    public final ReadOnlyIntegerProperty personIdProperty() {
//        return personId.getReadOnlyProperty();
//    }
//
//    /* firstName Property */
//    public final String getFirstName() {
//        return firstName.get();
//    }
//
//    public final void setFirstName(String firstName) {
//        firstNameProperty().set(firstName);
//    }
//
//    public final StringProperty firstNameProperty() {
//        return firstName;
//    }
//
//
//    /* lastName Property */
//    public final String getLastName() {
//        return lastName.get();
//    }
//
//    public final void setLastName(String lastName) {
//        lastNameProperty().set(lastName);
//    }
//
//    public final StringProperty lastNameProperty() {
//        return lastName;
//    }
//
//    /* birthDate Property */
//    public final LocalDate getBirthDate() {
//        return birthDate.get();
//    }
//
//    public final void setBirthDate(LocalDate birthDate) {
//        birthDateProperty().set(birthDate);
//    }
//
//    public final ObjectProperty<LocalDate> birthDateProperty() {
//        return birthDate;
//    }
//
//    /* Domain specific business rules */
//    public boolean isValidBirthDate(LocalDate bdate) {
//        return isValidBirthDate(bdate, new ArrayList<>());
//    }
//
//    /* Domain specific business rules */
//    public boolean isValidBirthDate(LocalDate bdate, List<String> errorList) {
//        if (bdate == null) {
//            return true;
//        }
//
//        // Birth date cannot be in the future
//        if (bdate.isAfter(LocalDate.now())) {
//            errorList.add("Birth date must not be in future.");
//            return false;
//        }
//
//        return true;
//    }
//
//    /* Domain specific business rules */
//    public boolean isValidPerson(List<String> errorList) {
//        return isValidPerson(this, errorList);
//    }
//
//    /* Domain specific business rules */
//    public boolean isValidPerson(Person p, List<String> errorList) {
//        boolean isValid = true;
//
//        String fn = p.firstName.get();
//        if (fn == null || fn.trim().length() == 0) {
//            errorList.add("First name must contain minimum one character.");
//            isValid = false;
//        }
//
//        String ln = p.lastName.get();
//        if (ln == null || ln.trim().length() == 0) {
//            errorList.add("Last name must contain minimum one character.");
//            isValid = false;
//        }
//
//        if (!isValidBirthDate(this.birthDate.get(), errorList)) {
//            isValid = false;
//        }
//
//        return isValid;
//    }
//
//    /* Domain specific business rules */
//    public AgeCategory getAgeCategory() {
//        if (birthDate.get() == null) {
//            return AgeCategory.UNKNOWN;
//        }
//
//        long years = ChronoUnit.YEARS.between(birthDate.get(), LocalDate.now());
//        if (years >= 0 && years < 2) {
//            return AgeCategory.BABY;
//        }
//        else if (years >= 2 && years < 13) {
//            return AgeCategory.CHILD;
//        }
//        else if (years >= 13 && years <= 19) {
//            return AgeCategory.TEEN;
//        }
//        else if (years > 19 && years <= 50) {
//            return AgeCategory.ADULT;
//        }
//        else if (years > 50) {
//            return AgeCategory.SENIOR;
//        } else {
//            return AgeCategory.UNKNOWN;
//        }
//    }
//
//    /* Domain specific business rules */
//    public boolean save(List<String> errorList) {
//        boolean isSaved = false;
//        if (isValidPerson(errorList)) {
//            System.out.println("Saved " + this.toString());
//            isSaved = true;
//        }
//
//        return isSaved;
//    }
//
//    @Override
//    public String toString() {
//        return "[personId=" + personId.get() +
//                ", firstName=" + firstName.get() +
//                ", lastName=" + lastName.get() +
//                ", birthDate=" + birthDate.get() + "]";
//    }
//}

//    TableColumn<Person, String> fNameCol = new TableColumn<>("First Name");
//		fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));