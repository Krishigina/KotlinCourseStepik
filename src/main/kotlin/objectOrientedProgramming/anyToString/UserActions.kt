package org.example.objectOrientedProgramming.anyToString

enum class UserActions(val title: String) {
    LOGIN("Login"),
    LOGOUT("Logout"),
    CLICK_BUTTON("Click button"),
    VIEW_PAGE("View page");

    override fun toString(): String {
        return "UserAction: ${this.title}"
    }
}
