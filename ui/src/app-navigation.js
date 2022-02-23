import i18n from "@/i18n";

export default [
  {
    text: i18n.t('app.menu.home'),
    path: "/home",
    icon: "home"
  },
  {
    text: i18n.t('app.menu.general.text'),
    icon: "folder",
    items: [
      {
        text: i18n.t('app.menu.general.user.text'),
        icon:"folder",
        items: [
          {
            text: i18n.t("app.menu.general.user.add"),
            path: "/security/add-user"
          },
          {
            text: i18n.t("app.menu.general.user.list"),
            path: "/tasks"
          }
        ]
      },

    ]
  }
  ];
