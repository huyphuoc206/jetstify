<template>
  <v-container fluid>
    <v-icon color="green" size="70">mdi-play-circle</v-icon>
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left"># TITLE</th>
            <th class="text-left">ALBUM</th>
            <th class="text-left">DATE ADDED</th>
            <th class="text-left">
              <v-icon>mdi-clock-outline</v-icon>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in desserts" :key="item.name">
            <td :style="{ border: 'none' }">{{ item.title }}</td>
            <td :style="{ border: 'none' }">{{ item.album }}</td>
            <td :style="{ border: 'none' }">
              {{ item.date }}
            </td>
            <td :style="{ border: 'none' }">
              <v-icon> mdi-heart </v-icon>
              {{ item.time }}
            </td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
  </v-container>
</template>

<script>
export default {
  name: "PlaylistService",
  data: () => ({
    desserts: [
      { title: "Follow", album: "a", date: "1 day ago", time: "3:03" },
      { title: "Follow", album: "s", date: "1 day ago", time: "3:03" },
      { title: "Follow", album: "a", date: "1 day ago", time: "3:03" },
      { title: "Follow", album: "a", date: "1 day ago", time: "3:03" },
      { title: "Follow", album: "a", date: "1 day ago", time: "3:03" },
    ],
  }),
};
</script>

<style lang="scss"></style>
