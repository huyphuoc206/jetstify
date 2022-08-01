<template>
  <v-navigation-drawer
    v-model="drawer"
    :mini-variant.sync="mini"
    permanent
    color="#2C3A47"
    dark
    app
  >
    <v-list-item class="px-2 pt-1" @click="$router.push('/admin/home')">
      <v-list-item-avatar>
        <v-img src="@/assets/IMG_0602.jpg" alt="admin" class="mx-auto" />
      </v-list-item-avatar>
      <v-list-item-title class="ml-4 text-capitalize"
        >Jestify</v-list-item-title
      >
    </v-list-item>
    <v-list shaped>
      <template v-for="item in items">
        <v-list-group
          v-if="item.children"
          :key="item.text"
          v-model="item.model"
          :prepend-icon="item['icon-ctr']"
          :append-icon="item.model ? item.icon : item['icon-alt']"
          active-class="orange--text"
        >
          <template v-slot:activator>
            <v-list-item-content>
              <v-list-item-title>
                {{ item.text }}
              </v-list-item-title>
            </v-list-item-content>
          </template>
          <v-list-item
            v-for="(child, i) in item.children"
            :key="i"
            route
            :to="child.route"
            active-class="orange--text"
          >
            <v-list-item-action v-if="child.icon">
              <v-icon>{{ child.icon }}</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title>
                {{ child.text }}
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-group>
        <v-list-item
          v-else
          :key="item.text"
          active-class="orange--text"
          route
          :to="item.route"
        >
          <v-list-item-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
              {{ item.text }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </template>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {
  name: "AppNavigationAdmin",
  data: () => ({
    drawer: null,
    mini: false,
    items: [
      { icon: "mdi-home", text: "Dashboard", route: "/admin/home" },
      { icon: "mdi-format-list-bulleted-type", text: "Category", route: "/admin/category" },
    //   {
    //     icon: "mdi-chevron-up",
    //     "icon-alt": "mdi-chevron-down",
    //     "icon-ctr": "mdi-cart-arrow-right",
    //     text: "Orders",
    //     model: false,
    //     children: [
    //       { icon: "style", text: "Type", route: "/Type" },
    //       { icon: "atm", text: "Mark", route: "/Mark" },
    //     ],
    //   },
      
    ],
  }),
};
</script>