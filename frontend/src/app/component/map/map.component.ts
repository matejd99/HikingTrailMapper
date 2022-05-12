import {
  AfterViewInit,
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import * as L from 'leaflet';
import '@geoman-io/leaflet-geoman-free';

// https://www.digitalocean.com/community/tutorials/angular-angular-and-leaflet
@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css'],
})
export class MapComponent implements OnInit, AfterViewInit {
  private map: L.Map | undefined;
  private trailMap: L.GeoJSON | undefined;

  private _trail: any;

  @Input() set trail(trail: any) {
    this._trail = trail;
    this.updateTrail();
  }
  @Output() trailChange = new EventEmitter<any>();

  @ViewChild('map') mapEl: any;

  constructor() {}

  private initMap(): void {
    this.map = L.map(this.mapEl.nativeElement, {
      center: [41.990659, 21.37946],
      zoom: 16,
    });

    this.map.pm.addControls({
      drawMarker: false,
      drawCircleMarker: false,
      drawPolyline: true,
      drawRectangle: false,
      drawPolygon: false,
      drawCircle: false,
      editMode: false,
      dragMode: false,
      cutPolygon: false,
      removalMode: false,
    });

    const tiles = L.tileLayer(
      'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
      {
        maxZoom: 18,
        minZoom: 3,
        attribution:
          '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>',
      }
    );

    let originalLayer: undefined | L.Layer;

    this.map.on('pm:create', (e) => {
      if (originalLayer) {
        originalLayer.remove();
      }
      originalLayer = e.layer;
      console.log(e.layer.toGeoJSON());
      console.log(e);
      this.trailChange.next(e.layer.toGeoJSON());
    });

    this.trailMap = L.geoJSON();

    tiles.addTo(this.map);
    this.trailMap.addTo(this.map);

    this.updateTrail();
  }

  private updateTrail() {
    if (this._trail && this.trailMap) {
      this.trailMap?.clearLayers();
      this.trailMap?.addData(this._trail);
      console.log("Here");
      console.log(this.trailMap.getBounds());
      this.map?.fitBounds(this.trailMap.getBounds());
    }
  }

  ngAfterViewInit(): void {
    this.initMap();
  }

  ngOnInit(): void {}
}
