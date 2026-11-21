SOLARAPP PROJECT
|-----------------|--------------------|
|Rabson Lungu     | 2410269            |
|-----------------|--------------------|


THE PROBLEM

Many people in rural communities face challenges accessing reliable electricity for charging mobile phones and small devices. They often spend time and money traveling long distances to find charging services, while others struggle to estimate the solar power needed to charge their devices efficiently. SolarApp was developed to help rural residents, small business owners, and community members calculate solar charging requirements and locate nearby charging stations, making access to charging services easier and more affordable.

This clearly explains:

The problems solved: lack of easy access to charging services and difficulty calculating solar charging needs.
The target users: rural communities, small business owners, and other people who rely on solar charging solutions.

HOW TO BUILD AND RUN

Clone the repository from GitHub:

git clone https://github.com/your-username/SolarApp.git


Open the SolarApp project folder in Android Studio.

Wait for Gradle Sync to complete and allow all project dependencies to download.

Connect an Android device via USB or start an Android Emulator from Android Studio.



Build the project by selecting:

Build > Make Project


Run the application by clicking the Run ▶ button in Android Studio.

Once the app launches, log in and access features such as the Solar Calculator and Charging Stations finder.

Test the application's functionality on either the emulator or a physical Android device.

This section is suitable for inclusion directly in your README.md under "HOW TO BUILD AND RUN".


Screens and What They Do
1. Login Screen
Allows users to enter their email and password.
Validates login credentials.
Navigates users to the Home Screen after successful login.

2. Home Screen
Serves as the main navigation hub of the app.
Provides access to all major features of SolarApp.
Allows users to choose between the Solar Calculator and Charging Stations functions.

3. Solar Calculator Screen
Accepts device power requirements as input.
Calculates the solar energy needed to charge the device.
Displays the estimated charging requirements and results.
Includes a back button to return to the Home Screen.

4. Find Charging Stations Screen
Displays available charging stations.
Shows station names and locations.
Helps users identify nearby charging options.
Includes a back button to return to the Home Screen.

Summary of Features
User authentication through email and password.
Solar charging requirement calculations.
Charging station information lookup.
Simple navigation between screens.
User-friendly interface designed for rural communities.

Since your SolarApp uses Jetpack Compose and Navigation between screens, these are two strong concepts to discuss in your research note.

Research Note 1: Jetpack Compose
What It Is

Jetpack Compose is Android's modern toolkit for building native user interfaces using Kotlin. Instead of creating screen layouts with XML files, developers create UI components directly in Kotlin code using functions called @Composable. This approach makes UI development faster, easier to maintain, and more flexible. Compose follows a declarative programming style, where developers describe what the user interface should look like based on the current state of the application.

Why My App Needs It

SolarApp uses Jetpack Compose to create all its screens, including the Login Screen, Home Screen, Solar Calculator Screen, and Charging Stations Screen. Compose allows the application to display user inputs, buttons, text fields, and calculation results in a clean and organized manner. It also makes the app easier to scale because new screens and features can be added without managing complex XML layouts.

Where I Learned It

The main source of learning was the official Android documentation:

Android Developers Documentation: https://developer.android.com/jetpack/compose
Android Developers Compose Tutorial: https://developer.android.com/jetpack/compose/tutorial
Android Developers Codelabs for Jetpack Compose
Kotlin Documentation: https://kotlinlang.org/docs/home.html

These resources provided explanations, examples, and best practices for building user interfaces with Compose.

What Went Wrong and How I Fixed It

While developing SolarApp, I experienced several challenges with Jetpack Compose. Initially, I received errors because some functions were not declared with the @Composable annotation. As a result, Android Studio generated compilation errors whenever these functions were used within the UI. I fixed this by ensuring that all screen functions were properly annotated with @Composable.

Another challenge was organizing files after changing the project directory structure. Some screens could not be located because package names did not match the folder structure. I resolved this issue by updating the package declarations and imports to match the new project structure. After correcting the package paths, the application compiled successfully and the screens became accessible.

Research Note 2: Navigation in Jetpack Compose
What It Is

Navigation in Jetpack Compose is a framework that allows users to move between different screens within an Android application. It uses a Navigation Controller (NavController) and a Navigation Host (NavHost) to manage screen transitions. Navigation helps developers define routes and destinations while maintaining a smooth user experience.

Why My App Needs It

SolarApp contains multiple screens that users must access during normal usage. Users start from the Login Screen and then proceed to the Home Screen. From the Home Screen, they can navigate to the Solar Calculator Screen or the Charging Stations Screen. Navigation is therefore essential for connecting all parts of the application and ensuring users can move between features efficiently. It also enables the use of back buttons so users can return to previous screens.

Where I Learned It

The primary learning resources included:

Android Developers Navigation Documentation: https://developer.android.com/guide/navigation
Navigation Compose Documentation: https://developer.android.com/jetpack/compose/navigation
Android Developers Codelabs
Kotlin Programming Documentation

These resources explained how to create routes, configure a NavHost, use a NavController, and manage screen transitions within Compose applications.

What Went Wrong and How I Fixed It

One of the main challenges was configuring navigation routes correctly. Some navigation actions failed because route names defined in the NavHost did not exactly match the route names used in navigation calls. This caused runtime errors and prevented screen transitions.

Another issue involved implementing back buttons on the Calculator and Charging Stations screens. Initially, the buttons did not return users to the previous screen. I fixed this by using the Navigation Controller's popBackStack() function, which correctly returns users to the previous destination.

After correcting route names and implementing proper navigation actions, users could smoothly move between all screens in the application without errors.

These two concepts were critical to the successful development of SolarApp because they provided the foundation for the application's user interface and screen navigation.
