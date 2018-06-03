# CurveNumbers
Used technologies:

•	Kotlin

•	RxJava2

•	Dagger 2

•	Android Architecture components

•	JUnit4

•	Constraintlayout


Demonstrating flashing total numbers in 5 different ways:

•	Handler

•	Timer

•	Animation

•	RxJava Observable.interval

•	RxJava Schedulers.newThread


Improving ideas:

•	Using enum, or sealed classes to identify the flashing modes

•	Add espresso Instrumentation tests

•	Use RecycleView and GridlayoutManager instead of normal Gridlayout

I could use TextWatcher to getting the value from the editText, or two way databinding with viewModel extend BaseObservable, but we don’t need any of this when we can do two way databinding with ViewModel, and LiveData from the Android Architecture Components ☺
